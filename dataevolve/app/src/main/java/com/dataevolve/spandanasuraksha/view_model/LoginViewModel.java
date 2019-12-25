package com.dataevolve.spandanasuraksha.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dataevolve.spandanasuraksha.model.OtpCheckRequest;
import com.dataevolve.spandanasuraksha.model.OtpCheckResponse;
import com.dataevolve.spandanasuraksha.model.OtpRequest;
import com.dataevolve.spandanasuraksha.model.OtpResponse;
import com.dataevolve.spandanasuraksha.repository.LoginRepository;

public class LoginViewModel extends AndroidViewModel {

    private LoginRepository loginRepository;
    private LiveData<OtpResponse> otpResponseLiveData;
    private LiveData<OtpCheckResponse> otpCheckResponseLiveData;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository=new LoginRepository();
    }
    public LiveData<OtpResponse> getOtpResponseLiveData(OtpRequest otpRequest) {
        this.otpResponseLiveData = loginRepository.getOtp(otpRequest);
        return otpResponseLiveData;
    }

    public LiveData<OtpCheckResponse> getOtpCheckResponseLiveData(OtpCheckRequest otpCheckRequest) {
        this.otpCheckResponseLiveData = loginRepository.sendOtp(otpCheckRequest);
        return otpCheckResponseLiveData;
    }
}