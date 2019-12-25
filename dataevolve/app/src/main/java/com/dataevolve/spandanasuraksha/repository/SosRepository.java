package com.dataevolve.spandanasuraksha.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dataevolve.spandanasuraksha.model.OtpCheckRequest;
import com.dataevolve.spandanasuraksha.model.OtpCheckResponse;
import com.dataevolve.spandanasuraksha.model.OtpRequest;
import com.dataevolve.spandanasuraksha.model.OtpResponse;
import com.dataevolve.spandanasuraksha.model.SosRequest;
import com.dataevolve.spandanasuraksha.model.SosRespones;
import com.dataevolve.spandanasuraksha.retrofit.ApiRequest;
import com.dataevolve.spandanasuraksha.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SosRepository {

    private ApiRequest apiRequest;

    public SosRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<SosRespones> sendSosRequest(SosRequest sosRequest,String token,String number) {
        final MutableLiveData<SosRespones> data = new MutableLiveData<>();
        try {
            apiRequest.sendSOS(sosRequest,token,number).enqueue(new Callback<SosRespones>() {
                @Override
                public void onResponse(Call<SosRespones> call, Response<SosRespones> response) {
                    if (response.body() != null) {
                        data.setValue(response.body());
                        Log.i("Mallikarjuna", "+++sucess+++" + response.toString());
                    }
                }

                @Override
                public void onFailure(Call<SosRespones> call, Throwable t) {
                    data.setValue(null);
                    Log.i("Mallikarjuna", "+++error+++" + t.getMessage());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
