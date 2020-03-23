package com.t.meditationapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.ModelClasses.GetProfileResponse;
import com.t.meditationapp.ModelClasses.GetVoiceData;
import com.t.meditationapp.ModelClasses.GetVoiceResponse;
import com.t.meditationapp.R;
import com.t.meditationapp.adapter.VoiceAdapter;
import com.t.meditationapp.javaActivities.AccountSettingActivityNew;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoiceSelect_Activity extends AppCompatActivity {
    TextView img_next;
    ImageView img_back_tool;
    LinearLayout ll_alice_bg, ll_tiff_bg, ll_kevin_bg;
    ApiInterface apiInterface;
    GetVoiceResponse resource;
    RecyclerView recyclerView;
    List<GetVoiceData> voiceData;
    Integer[] id_unselected = {R.mipmap.alice_bg,R.mipmap.signup_fb_bg,R.mipmap.blue_curve_bg};
    Integer[] id_selected = {R.mipmap.alice_bg_two,R.mipmap.signup_fb_bg_two,R.mipmap.blue_curve_bg_two};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_select_activity);
        img_next = (TextView) findViewById(R.id.img_next);
        ll_alice_bg = (LinearLayout) findViewById(R.id.ll_alice_bg);
        ll_tiff_bg = (LinearLayout) findViewById(R.id.ll_tiff_bg);
        ll_kevin_bg = (LinearLayout) findViewById(R.id.ll_kevin_bg);
        recyclerView = findViewById(R.id.voice_select_rv);

        retrofitGetVoice();

        img_back_tool = (ImageView) findViewById(R.id.img_back_tool);

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat = new Intent(VoiceSelect_Activity.this, CategoriesActivities.class);
                startActivity(cat);
            }
        });
        img_back_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat = new Intent(VoiceSelect_Activity.this, LogOut_Activity.class);
                startActivity(cat);
                finish();
            }
        });

        ll_alice_bg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ll_alice_bg.setBackgroundResource(R.mipmap.alice_bg);
                ll_tiff_bg.setBackgroundResource(R.mipmap.signup_fb_bg);
                ll_kevin_bg.setBackgroundResource(R.mipmap.blue_curve_bg);
            }
        });
        ll_tiff_bg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ll_alice_bg.setBackgroundResource(R.mipmap.alice_bg_two);
                ll_tiff_bg.setBackgroundResource(R.mipmap.signup_fb_bg_two);
                ll_kevin_bg.setBackgroundResource(R.mipmap.blue_curve_bg);

            }
        });
        ll_kevin_bg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ll_alice_bg.setBackgroundResource(R.mipmap.alice_bg_two);
                ll_tiff_bg.setBackgroundResource(R.mipmap.signup_fb_bg);
                ll_kevin_bg.setBackgroundResource(R.mipmap.blue_curve_bg_two);

            }
        });
    }

    public void retrofitGetVoice(){
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<GetVoiceResponse> call = apiInterface.getVoiceResponse();
        call.enqueue(new Callback<GetVoiceResponse>() {
            @Override
            public void onResponse(Call<GetVoiceResponse> call, Response<GetVoiceResponse> response) {

                if (response.isSuccessful()) {
                    resource = response.body();
                    assert resource != null;
                    Log.e("success", resource.getMessages());
                    if (resource.getSuccess()) {
                        voiceData = resource.getData();
                        recyclerView.setLayoutManager(new LinearLayoutManager(VoiceSelect_Activity.this));
                        VoiceAdapter adapter = new VoiceAdapter(voiceData,VoiceSelect_Activity.this);
                        recyclerView.setAdapter(adapter);

                    } else {
                        Toast.makeText(VoiceSelect_Activity.this, resource.getMessages(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<GetVoiceResponse> call, Throwable t) {

            }
        });
    }
}
