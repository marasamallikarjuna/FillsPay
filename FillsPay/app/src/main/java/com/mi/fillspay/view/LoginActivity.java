package com.mi.fillspay.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.mi.fillspay.R;
import com.mi.fillspay.model.LoginRequest;
import com.mi.fillspay.view_model.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    ImageView logoImageView;
    TextView titleTextView;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        logoImageView=findViewById(R.id.logoImageView);
        titleTextView=findViewById(R.id.titleTextView);

        //test commit

        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);

        findViewById(R.id.regTextView).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent   = new Intent(LoginActivity.this,RegistrationActivity.class);
                Pair[] pairs    = new Pair[1];
                pairs[0] = new Pair<View,String>(titleTextView,"tvLogin");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,activityOptions.toBundle());
            }
        });


        

        findViewById(R.id.loginImageView).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent   = new Intent(LoginActivity.this,HomeActivity.class);
                Pair[] pairs    = new Pair[1];
                pairs[0] = new Pair<View,String>(titleTextView,"tvLogin");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,activityOptions.toBundle());
            }
        });
    }

    private void sendLoginDetails(LoginRequest data) {

        loginViewModel.getLoginResponseLiveData(data).observe(this,loginResponse -> {

            if (loginResponse.getToken()!=null){

            }

        });
    }
}
