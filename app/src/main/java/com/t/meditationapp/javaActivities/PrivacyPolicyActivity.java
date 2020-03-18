package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.ModelClasses.GetResponsePricyAndPolicy;
import com.t.meditationapp.ModelClasses.GetResponseTermsAndCondition;
import com.t.meditationapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrivacyPolicyActivity extends AppCompatActivity {

    private CustomBoldtextView privacy_title_txt,privacy_description_Txt_view;
    private ImageView img_privacy_back;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_fragment);

        privacy_title_txt=findViewById(R.id.privacy_title_txt);
        privacy_description_Txt_view=findViewById(R.id.privacy_description_Txt_view);
        img_privacy_back=findViewById(R.id.img_privacy_back);

        img_privacy_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        apiInterface= RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<GetResponsePricyAndPolicy> call=apiInterface.privacyAndPolicy();

        call.enqueue(new Callback<GetResponsePricyAndPolicy>() {
            @Override
            public void onResponse(Call<GetResponsePricyAndPolicy> call, Response<GetResponsePricyAndPolicy> response) {

                GetResponsePricyAndPolicy getResponsePricyAndPolicy=response.body();

                privacy_title_txt.setText(getResponsePricyAndPolicy.getData().getTitle());
                privacy_description_Txt_view.setText(getResponsePricyAndPolicy.getData().getDescription());

            }

            @Override
            public void onFailure(Call<GetResponsePricyAndPolicy> call, Throwable t) {

            }
        });



    }
}
