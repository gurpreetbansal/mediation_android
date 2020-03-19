package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.ModelClasses.LogoutModelClass;
import com.t.meditationapp.R;
import com.t.meditationapp.activities.HelpCenter_Activity;
import com.t.meditationapp.activities.VoiceSelect_Activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoutActivity extends AppCompatActivity {

    private CustomBoldtextView txt_no,txt_yes,txt_help_center_quit;

    ApiInterface apiInterface;
    LogoutModelClass logoutModelClass=new LogoutModelClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quit_activity);

        txt_yes=findViewById(R.id.txt_yes);
        txt_no=findViewById(R.id.txt_no);
        txt_help_center_quit=findViewById(R.id.txt_help_center_quit);

        SharedPreferences sharedPreferences=getSharedPreferences("mypref",0);
        final String userid =sharedPreferences.getString("user_id","");


        txt_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLogout(userid);
            }
        });

        txt_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txt_help_center_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LogoutActivity.this, HelpCenter_Activity.class);
                startActivity(intent);

            }
        });
    }

    private void getLogout(String userid) {

        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<LogoutModelClass> call = apiInterface.getLogout(userid);

        call.enqueue(new Callback<LogoutModelClass>() {
            @Override
            public void onResponse(Call<LogoutModelClass> call, Response<LogoutModelClass> response) {

//                if (response != null){

                    LogoutModelClass logoutModelClass=response.body();

                    if (logoutModelClass.getSuccess()) {

                        SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("user_id",null);
                        editor.apply();

                        Toast.makeText(LogoutActivity.this, logoutModelClass.getMessages(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogoutActivity.this, LoginActivityNew.class));
                        finishAffinity();

                    }


//                }

//                if (response.isSuccessful()){
//
//                    LogoutModelClass logoutModelClass=response.body();
//
//                    if (logoutModelClass.getSuccess())
//
//                    SharedPreferences sharedPreferences=getSharedPreferences("mypref",0);
//
//                }

            }

            @Override
            public void onFailure(Call<LogoutModelClass> call, Throwable t) {

                t.printStackTrace();

            }
        });

    }
}
