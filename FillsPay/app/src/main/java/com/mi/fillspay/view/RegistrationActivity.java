package com.mi.fillspay.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.mi.fillspay.R;
import com.mi.fillspay.model.LoginRequest;
import com.mi.fillspay.model.RegisterRequest;
import com.mi.fillspay.view_model.LoginViewModel;
import com.mi.fillspay.view_model.RegisterViewModel;

public class RegistrationActivity extends AppCompatActivity {

    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        registerViewModel= ViewModelProviders.of(this).get(RegisterViewModel.class);

        findViewById(R.id.loginTextview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void sendLoginDetails(RegisterRequest data) {

        registerViewModel.getRegisterResponseLiveData(data).observe(this,responseData -> {

            if (responseData.getMessage().equals("Success")){

            }

        });
    }

}
