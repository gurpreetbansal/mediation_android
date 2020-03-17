package com.t.meditationapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t.meditationapp.R;

public class VoiceSelect_Activity extends AppCompatActivity {
TextView img_next;
    ImageView img_back_tool;
    LinearLayout ll_alice_bg,ll_tiff_bg,ll_kevin_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_select_activity);
        img_next=(TextView)findViewById(R.id.img_next);
        ll_alice_bg=(LinearLayout)findViewById(R.id.ll_alice_bg);
        ll_tiff_bg=(LinearLayout)findViewById(R.id.ll_tiff_bg);
        ll_kevin_bg=(LinearLayout)findViewById(R.id.ll_kevin_bg);

        img_back_tool=(ImageView) findViewById(R.id.img_back_tool);
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat=new Intent(VoiceSelect_Activity.this,CategoriesActivities.class);
                startActivity(cat);
            }
        });
        img_back_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ll_alice_bg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ll_alice_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.alice_bg));
                ll_tiff_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.signup_fb_bg));
                ll_kevin_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.blue_curve_bg));
            }
        });
        ll_tiff_bg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ll_alice_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.alice_bg_two));
                ll_tiff_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.signup_fb_bg_two));
                ll_kevin_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.blue_curve_bg));

            }
        });
        ll_kevin_bg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ll_alice_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.alice_bg_two));
                ll_tiff_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.signup_fb_bg));
                ll_kevin_bg.setBackgroundDrawable(getResources().getDrawable(R.mipmap.blue_curve_bg_two));

            }
        });
    }
}
