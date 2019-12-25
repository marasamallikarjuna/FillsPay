package com.dataevolve.spandanasuraksha.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.dataevolve.spandanasuraksha.model.OtpCheckRequest;
import com.dataevolve.spandanasuraksha.model.OtpCheckResponse;
import com.dataevolve.spandanasuraksha.model.OtpRequest;
import com.dataevolve.spandanasuraksha.model.OtpResponse;
import com.dataevolve.spandanasuraksha.retrofit.ApiRequest;
import com.dataevolve.spandanasuraksha.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginRepository {

    private ApiRequest apiRequest;

    public LoginRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }
    public LiveData<OtpResponse> getOtp(OtpRequest otpRequest) {
        final MutableLiveData<OtpResponse> data = new MutableLiveData<>();
        try {
            apiRequest.getOTP(otpRequest).enqueue(new Callback<OtpResponse>() {
                @Override
                public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
                    if (response.body() != null) {
                        data.setValue(response.body());
                        Log.i("Mallikarjuna","+++sucess+++"+response.toString());
                    }
                }
                @Override
                public void onFailure(Call<OtpResponse> call, Throwable t) {
                    data.setValue(null);
                    Log.i("Mallikarjuna","+++error+++"+t.getMessage());
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public LiveData<OtpCheckResponse> sendOtp(OtpCheckRequest otpCheckRequest) {
        final MutableLiveData<OtpCheckResponse> data = new MutableLiveData<>();
        try {
            apiRequest.sendOTP(otpCheckRequest).enqueue(new Callback<OtpCheckResponse>() {
                @Override
                public void onResponse(Call<OtpCheckResponse> call, Response<OtpCheckResponse> response) {
                    if (response.body() != null) {
                        data.setValue(response.body());
                        Log.i("Mallikarjuna","+++sucess+++"+response.toString());
                    }
                }
                @Override
                public void onFailure(Call<OtpCheckResponse> call, Throwable t) {
                    data.setValue(null);
                    Log.i("Mallikarjuna","+++error+++"+t.getMessage());
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
