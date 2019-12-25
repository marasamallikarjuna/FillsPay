package com.dataevolve.spandanasuraksha.view;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;

import com.dataevolve.spandanasuraksha.R;
import com.dataevolve.spandanasuraksha.model.OtpCheckRequest;
import com.dataevolve.spandanasuraksha.model.OtpRequest;
import com.dataevolve.spandanasuraksha.view_model.LoginViewModel;

public class LoginActivity extends BaseActivity{

    int counter = 30;
    RelativeLayout getOTPLayout,submitOtpLayout;
    Button getOtpButton,submitOtpButton;
    EditText mobileEditText,otpEdit1,otpEdit2,otpEdit3,otpEdit4,otpEdit5,otpEdit6;
    TextView dynText,reSendText,timerText;
    LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        getOTPLayout=findViewById(R.id.get_otp_layout);
        submitOtpLayout=findViewById(R.id.submit_otp_layout);
        getOtpButton=findViewById(R.id.get_otp_btn);
        submitOtpButton=findViewById(R.id.submit_otp_btn);
        mobileEditText=(EditText) findViewById(R.id.mmobile_otp);
        dynText=findViewById(R.id.loginText);
        reSendText=findViewById(R.id.reSendText);
        timerText=findViewById(R.id.timeText);
        otpEdit1=findViewById(R.id.otp1);
        otpEdit2=findViewById(R.id.otp2);
        otpEdit3=findViewById(R.id.otp3);
        otpEdit4=findViewById(R.id.otp4);
        otpEdit5=findViewById(R.id.otp5);
        otpEdit6=findViewById(R.id.otp6);

        otpEdit1.addTextChangedListener(new GenericTextWatcher(otpEdit1));
        otpEdit2.addTextChangedListener(new GenericTextWatcher(otpEdit2));
        otpEdit3.addTextChangedListener(new GenericTextWatcher(otpEdit3));
        otpEdit4.addTextChangedListener(new GenericTextWatcher(otpEdit4));
        otpEdit5.addTextChangedListener(new GenericTextWatcher(otpEdit5));
        otpEdit6.addTextChangedListener(new GenericTextWatcher(otpEdit6));

        mobileEditText.addTextChangedListener(new GenericTextWatcher(mobileEditText));




        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);

        getOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mobileEditText.getText().toString().length()==10){
                   if(numberValidate(mobileEditText.getText().toString())){
                       try {
                           showProgress();
                           OtpRequest otpRequest = new OtpRequest();
                           otpRequest.setUsrPhNm(mobileEditText.getText().toString().trim());

                           getOtp(otpRequest);
                       }catch (Exception e){
                           e.printStackTrace();
                           stopProgress();
                       }
                   }else{
                       Toast.makeText(getApplicationContext(),"Enter a valid mobile number",Toast.LENGTH_SHORT).show();
                   }
                }else{
                    Toast.makeText(getApplicationContext(),"Enter a valid mobile number",Toast.LENGTH_SHORT).show();
                }
            }
        });

        reSendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    showProgress();
                    OtpRequest otpRequest = new OtpRequest();
                    otpRequest.setUsrPhNm(mobileEditText.getText().toString().trim());
                    getOtp(otpRequest);
                }catch (Exception e){
                    e.printStackTrace();
                    stopProgress();
                }

            }
        });

        submitOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp=otpEdit1.getText().toString()+otpEdit2.getText().toString()+otpEdit3.getText().toString()
                        +otpEdit4.getText().toString()+otpEdit5.getText().toString()+otpEdit6.getText().toString();
                otp.trim();
                if (otp.length()==6){
                    try {
                        showProgress();
                        OtpCheckRequest otpCheckRequest = new OtpCheckRequest();
                        otpCheckRequest.setOtpNo(otp);
                        otpCheckRequest.setUsrPhNm(mobileEditText.getText().toString());
                        sendOTP(otpCheckRequest);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Enter a valid OTP ",Toast.LENGTH_SHORT).show();

                }
            }
        });



    }

    private void sendOTP(OtpCheckRequest otpCheckRequest) {

        loginViewModel.getOtpCheckResponseLiveData(otpCheckRequest).observe(this,otpCheckResponse -> {
            stopProgress();
            if (otpCheckResponse.getStatus()==200){
                if (otpCheckResponse.getMsg().equals("otp matched successfully")){
                    if (otpCheckResponse.getData().getToken()!=null){
                        _preferencesHelper.setAccessToken(otpCheckResponse.getData().getToken());
                        _preferencesHelper.setCurrentUserId(String.valueOf(otpCheckResponse.getData().getUsr_ph_nm()));
                        _preferencesHelper.setCurrentUserProfilein(otpCheckResponse.getData().getProfileIn());
                        Toast.makeText(getApplicationContext(),"Login successfully", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Token error", Toast.LENGTH_SHORT).show();
                    }
                }

            }else{
                Toast.makeText(getApplicationContext(), otpCheckResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void getOtp(OtpRequest otpRequest) {

        loginViewModel.getOtpResponseLiveData(otpRequest).observe(this,otpResponse->{

            stopProgress();
            if (otpResponse.getStatus()==200) {
                if (otpResponse.getData().getMessage().contains("402,")) {
                    mobileEditText.setEnabled(false);
                    getOTPLayout.setVisibility(View.GONE);
                    submitOtpLayout.setVisibility(View.VISIBLE);
                    reSendText.setVisibility(View.GONE);
                    dynText.setText("We have sent a six digit OTP on +91-" + mobileEditText.getText().toString());
                    Log.i("Malliakrjuna", "++ss++" + otpResponse.getData().getMessage());
                    Log.i("Malliakrjuna", "++ss++" + otpResponse.getStatus());

                    updateTimer();
                } else {
                    Toast.makeText(getApplicationContext(), otpResponse.getData().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), otpResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }

        });


    }

    private void updateTimer() {


        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                timerText.setText("Where is my OTP? Wait "+String.valueOf(counter)+" Sec");
                timerText.setVisibility(View.VISIBLE);
                counter--;
            }
            public  void onFinish(){
                timerText.setVisibility(View.GONE);
                reSendText.setVisibility(View.VISIBLE);
                counter=30;
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
        super.onBackPressed();
    }


    public class GenericTextWatcher implements TextWatcher {
        private View view;
        private GenericTextWatcher(View view)
        {
            this.view = view;
        }
        @Override
        public void afterTextChanged(Editable editable) {
            // TODO Auto-generated method stub
            String text = editable.toString();
            switch(view.getId())
            {
                case R.id.otp1:
                    if(text.length()==1)
                        otpEdit2.requestFocus();
                    break;
                case R.id.otp2:
                    if(text.length()==1)
                        otpEdit3.requestFocus();
                    else if(text.length()==0)
                        otpEdit1.requestFocus();
                    break;
                case R.id.otp3:
                    if(text.length()==1)
                        otpEdit4.requestFocus();
                    else if(text.length()==0)
                        otpEdit2.requestFocus();
                    break;
                case R.id.otp4:
                    if(text.length()==1)
                        otpEdit5.requestFocus();
                    else if(text.length()==0)
                        otpEdit3.requestFocus();
                    break;
                case R.id.otp5:
                    if(text.length()==1)
                        otpEdit6.requestFocus();
                    else if(text.length()==0)
                        otpEdit4.requestFocus();
                    break;
                case R.id.otp6:
                    if(text.length()==1) {
                        hideKeyboard(LoginActivity.this);
                        submitOtpButton.setEnabled(true);
                    } else if(text.length()==0)
                        otpEdit5.requestFocus();
                    break;
                case R.id.mmobile_otp:
                    if(text.length()==10)
                        hideKeyboard(LoginActivity.this);
                    break;

            }
        }
        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
        }
    }

}
