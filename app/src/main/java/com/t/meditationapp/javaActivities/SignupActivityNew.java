package com.t.meditationapp.javaActivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.Custom_Widgets.CustomBoldEditText;
import com.t.meditationapp.ModelClasses.SignupModelClass;
import com.t.meditationapp.ModelClasses.SignupSendData;
import com.t.meditationapp.R;
import com.t.meditationapp.activities.VoiceSelect_Activity;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivityNew extends AppCompatActivity {

    LinearLayout ll_facebook;
    TextView txt_login, txt_sign_up;
    String email_txt, password_txt, name_txt, social_id, social_type, device_type = "Android", device_token, response;
    ApiInterface apiInterface;
    private SignupSendData sendData = new SignupSendData();
    CustomBoldEditText ed_email, ed_name, ed_password;

//    String mypreference = "mypref";
//    String user_id = "user_id";

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


        ed_email = findViewById(R.id.signup__email);
        ed_name = findViewById(R.id.signup__name);
        ed_password = findViewById(R.id.signup__password);

        ll_facebook = (LinearLayout) findViewById(R.id.ll_facebook);
        txt_login = (TextView) findViewById(R.id.signup_txt_login);
        txt_sign_up = (TextView) findViewById(R.id.signup__txt_sign_up);
        ll_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voice = new Intent(SignupActivityNew.this, VoiceSelect_Activity.class);
                startActivity(voice);
            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voice = new Intent(SignupActivityNew.this, LoginActivityNew.class);
                startActivity(voice);
            }
        });


        txt_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_txt = ed_name.getText().toString();
                email_txt = ed_email.getText().toString();
                password_txt = ed_password.getText().toString();

                Log.e("email", email_txt);


                if (validateName(name_txt, ed_name, "name is reuired")) {
                    return;
                }
                if (validateName(email_txt, ed_email, "email is required")) {
                    return;
                }
                if (validateName(password_txt, ed_password, "password is required")) {
                    return;
                }
                if (validatePassword(password_txt, ed_password, "pssword must be atleast 6 characters")) {
                    return;
                }

//                    SyncStateContract.Constants.deviceToken = UUID.randomUUID().toString();


                sendData.setFirstName(name_txt);
                sendData.setEmail(email_txt);
                sendData.setPassword(password_txt);

//                sendData.setSocialId(social_id);
//                sendData.setSocialType(social_type);
                sendData.setDeviceType(device_type);
                sendData.setDeviceToken(UUID.randomUUID().toString());
                Log.e("email+", sendData.getEmail());
                retrofitData();
            }
        });

    }

    public void retrofitData() {
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<SignupModelClass> call = apiInterface.signup(sendData);
        call.enqueue(new Callback<SignupModelClass>() {
            @Override
            public void onResponse(Call<SignupModelClass> call, Response<SignupModelClass> response) {

                if (response.isSuccessful()) {
                    SignupModelClass resource = response.body();
                    Toast.makeText(SignupActivityNew.this, resource.getMessages(), Toast.LENGTH_SHORT).show();
                    assert resource != null;
                    if (resource.getSuccess()) {
                        String code = resource.getCode();
                        String msg = resource.getMessages();

                        SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("user_id", resource.getData().getUserId());
                        editor.apply();

//                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
//                        pref = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
//                        pref.getString(user_id,"");

                        startActivity(new Intent(SignupActivityNew.this, VoiceSelect_Activity.class));
                        Toast.makeText(SignupActivityNew.this, msg, Toast.LENGTH_SHORT).show();

                        Log.e("Success Response++++", code + " " + msg);
                    } else {
                        Toast.makeText(SignupActivityNew.this, resource.getMessages(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SignupModelClass> call, Throwable t) {
                Log.e("Failure Response++++", t.getMessage());
                Toast.makeText(SignupActivityNew.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateName(String name, CustomBoldEditText nameET, String err_msg) {
        if (name.isEmpty()) {
            nameET.setError(err_msg);
            nameET.requestFocus();
            return true;
        }
        return false;
    }

    private boolean validatePassword(String name, CustomBoldEditText nameET, String err_msg) {
        if (name.length() < 6) {
            nameET.setError(err_msg);
            nameET.requestFocus();
            return true;
        }
        return false;
    }
}
