package com.t.meditationapp.javaActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.t.meditationapp.R;
import com.t.meditationapp.activities.LoginActivity;
import com.t.meditationapp.activities.SignUp_Activity;
import com.t.meditationapp.activities.VoiceSelect_Activity;

public class SignupActivity extends AppCompatActivity {

    LinearLayout ll_facebook;
    TextView txt_login, txt_sign_up;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_two_activity);

        // setStatusBaseWhiteMain();
        Window window = this.getWindow();
// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));


        ll_facebook = (LinearLayout) findViewById(R.id.ll_facebook);
        txt_login = (TextView) findViewById(R.id.txt_login);
        txt_sign_up = (TextView) findViewById(R.id.txt_sign_up);
        ll_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voice = new Intent(SignupActivity.this, VoiceSelect_Activity.class);
                startActivity(voice);
            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voice = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(voice);
            }
        });
        txt_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voice = new Intent(SignupActivity.this, VoiceSelect_Activity.class);
                startActivity(voice);
            }
        });

    }
}
