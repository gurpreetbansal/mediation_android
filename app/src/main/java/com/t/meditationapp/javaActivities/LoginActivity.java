package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.R;

public class LoginActivity extends AppCompatActivity {

    com.t.meditationapp.Custom_Widgets.CustomBoldEditText ed_password, ed_email;
    com.t.meditationapp.Custom_Widgets.CustomRegularTextView btn_login;
    CustomBoldtextView btn_signup;

    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_email = findViewById(R.id.login__email);
        ed_password = findViewById(R.id.login__password);
        btn_login = findViewById(R.id.login__txt_log_in);
        btn_signup = findViewById(R.id.txt_sign_up);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }
}
