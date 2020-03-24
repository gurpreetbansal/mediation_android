package com.t.meditationapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.ModelClasses.GetProfileResponse;
import com.t.meditationapp.ModelClasses.GetVoiceData;
import com.t.meditationapp.ModelClasses.GetVoiceResponse;
import com.t.meditationapp.R;
import com.t.meditationapp.adapter.VoiceAdapter;
import com.t.meditationapp.javaActivities.AccountSettingActivityNew;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.blackbox_vision.wheelview.view.DatePickerPopUpWindow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoiceSelect_Activity extends AppCompatActivity {
    TextView img_next;
    ImageView img_back_tool, toggle;
    LinearLayout ll_alice_bg, ll_tiff_bg, ll_kevin_bg;
    ApiInterface apiInterface;
    GetVoiceResponse resource;
    RecyclerView recyclerView;
    List<GetVoiceData> voiceData;
    CustomBoldtextView time;
    Integer[] id_unselected = {R.mipmap.alice_bg_two, R.mipmap.signup_fb_bg, R.mipmap.blue_curve_bg};
    Integer[] id_selected = {R.mipmap.alice_bg, R.mipmap.signup_fb_bg_two, R.mipmap.blue_curve_bg_two};
    int mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_select_activity);
        img_next = (TextView) findViewById(R.id.img_next);
        ll_alice_bg = (LinearLayout) findViewById(R.id.ll_alice_bg);
        ll_tiff_bg = (LinearLayout) findViewById(R.id.ll_tiff_bg);
        ll_kevin_bg = (LinearLayout) findViewById(R.id.ll_kevin_bg);
        recyclerView = findViewById(R.id.voice_select_rv);
        time = findViewById(R.id.voice_select_time);
        toggle = findViewById(R.id.toggleButton);

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

        LinearGradient shade = new LinearGradient(0f, 0f, 0f, time.getTextSize(), getResources().getColor(R.color.time_color_a), getResources().getColor(R.color.time_color_b), Shader.TileMode.CLAMP);
        time.getPaint().setShader(shade);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(VoiceSelect_Activity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                time.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();

            }
        });
    }

    public void retrofitGetVoice() {
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
                        VoiceAdapter adapter = new VoiceAdapter(voiceData, VoiceSelect_Activity.this, id_selected, id_unselected);
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
