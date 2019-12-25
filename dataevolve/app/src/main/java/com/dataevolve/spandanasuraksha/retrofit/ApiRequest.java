package com.dataevolve.spandanasuraksha.retrofit;


import com.dataevolve.spandanasuraksha.model.OtpCheckRequest;
import com.dataevolve.spandanasuraksha.model.OtpCheckResponse;
import com.dataevolve.spandanasuraksha.model.OtpRequest;
import com.dataevolve.spandanasuraksha.model.OtpResponse;
import com.dataevolve.spandanasuraksha.model.SosRequest;
import com.dataevolve.spandanasuraksha.model.SosRespones;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiRequest {

    @POST("/Api/getOtp")
    @Headers("Content-Type: application/json")
    Call<OtpResponse> getOTP(@Body OtpRequest body);

    @POST("/Api/checkOtp")
    @Headers("Content-Type: application/json")
    Call<OtpCheckResponse> sendOTP(@Body OtpCheckRequest body);

    @POST("/Api/SOS")
    @Headers("Content-Type: application/json")
    Call<SosRespones> sendSOS(@Body SosRequest body,@Header("token") String token,@Header("usr_ph_nm") String usr_ph_nm);
}
