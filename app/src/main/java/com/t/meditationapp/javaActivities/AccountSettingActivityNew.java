package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.ModelClasses.LoginModelClass;
import com.t.meditationapp.ModelClasses.SignupSendData;
import com.t.meditationapp.R;
import com.t.meditationapp.activities.VoiceSelect_Activity;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountSettingActivityNew extends AppCompatActivity {
    ImageView btn_back;
    String email_txt, password_txt, name_txt;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_two_fragment);

        btn_back = findViewById(R.id.img_account_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public void retrofitData() {
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call call = apiInterface.getProfile();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });

    }
}
