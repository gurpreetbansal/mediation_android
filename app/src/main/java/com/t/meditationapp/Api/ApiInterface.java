package com.t.meditationapp.Api;

import com.t.meditationapp.ModelClasses.ChangePasswordResponse;
import com.t.meditationapp.ModelClasses.GetEditProfileResponse;
import com.t.meditationapp.ModelClasses.GetProfileResponse;
import com.t.meditationapp.ModelClasses.GetResponsePricyAndPolicy;
import com.t.meditationapp.ModelClasses.GetResponseTermsAndCondition;
import com.t.meditationapp.ModelClasses.LoginModelClass;
import com.t.meditationapp.ModelClasses.LoginSendData;
import com.t.meditationapp.ModelClasses.LogoutModelClass;
import com.t.meditationapp.ModelClasses.PrivacyPolicyModelClass;
import com.t.meditationapp.ModelClasses.SignupModelClass;
import com.t.meditationapp.ModelClasses.SignupSendData;
import com.t.meditationapp.ModelClasses.TermsAndConditionModelClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("auth/register")
    Call<SignupModelClass> signup(@Body SignupSendData sendData);

    @POST("auth/login")
    Call<LoginModelClass> login(@Body LoginSendData loginSendData);

    @POST("auth/getProfile")
    Call<GetProfileResponse> getProfile(@Query("user_id") String userId);

    @POST("auth/editProfile")
    Call<GetEditProfileResponse> editProfile(@Query("user_id") String userId, @Query("first_name") String firstName, @Query("last_name") String lastName);

    @POST("auth/changePassword")
    Call<ChangePasswordResponse> changePassword(@Query("user_id") String userId, @Query("old_password") String oldPassword, @Query("new_password") String newPassword);
    @POST("auth/logout")
    Call<LogoutModelClass>  getLogout(@Query("user_id") String userid);

    @GET("auth/termsCondtions")
    Call<GetResponseTermsAndCondition> termsAndCondition();

    @GET("auth/privacyPolicy")
    Call<GetResponsePricyAndPolicy> privacyAndPolicy();




}
