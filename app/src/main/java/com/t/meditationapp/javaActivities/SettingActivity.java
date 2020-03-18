package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.ModelClasses.LogoutModelClass;
import com.t.meditationapp.R;

public class SettingActivity extends AppCompatActivity {

    private CustomBoldtextView txt_logout,txt_privacy,txt_terms_condition;

    ApiInterface apiInterface;
    LogoutModelClass logoutModelClass=new LogoutModelClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_fragment);

        txt_logout=findViewById(R.id.txt_logout);
        txt_privacy=findViewById(R.id.txt_privacy);
        txt_terms_condition=findViewById(R.id.txt_terms_condition);

        txt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SettingActivity.this,LogoutActivity.class);
                startActivity(intent);

            }
        });

        txt_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        txt_terms_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SettingActivity.this,TermsAndConditionActivity.class);
                startActivity(intent);

            }
        });

        txt_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SettingActivity.this,PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });

    }

    }
