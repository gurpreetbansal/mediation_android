package com.t.meditationapp.Api;

import com.t.meditationapp.ModelClasses.LoginModelClass;
import com.t.meditationapp.ModelClasses.LoginSendData;
import com.t.meditationapp.ModelClasses.SignupModelClass;
import com.t.meditationapp.ModelClasses.SignupSendData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("auth/register")
    Call<SignupModelClass> signup(@Body SignupSendData sendData);

    @POST("auth/login")
    Call<LoginModelClass> login(@Body LoginSendData loginSendData);

}
