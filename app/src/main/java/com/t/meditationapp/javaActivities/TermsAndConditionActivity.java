package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.ModelClasses.GetResponseTermsAndCondition;
import com.t.meditationapp.ModelClasses.TermsAndConditionModelClass;
import com.t.meditationapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TermsAndConditionActivity extends AppCompatActivity {

    private CustomBoldtextView title_txt_view,description_Txt_view;
    private ImageView img_back_terms;

    ApiInterface apiInterface;
//    TermsAndConditionModelClass termsAndConditionModelClass=new TermsAndConditionModelClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms_and_conditions_fragment);

        title_txt_view=findViewById(R.id.title_txt_view);
        description_Txt_view=findViewById(R.id.description_Txt_view);
        img_back_terms=findViewById(R.id.img_back_terms);

        img_back_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        apiInterface= RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<GetResponseTermsAndCondition> call=apiInterface.termsAndCondition();

        call.enqueue(new Callback<GetResponseTermsAndCondition>() {
            @Override
            public void onResponse(Call<GetResponseTermsAndCondition> call, Response<GetResponseTermsAndCondition> response) {

                GetResponseTermsAndCondition getResponseTermsAndCondition=response.body();

                title_txt_view.setText(getResponseTermsAndCondition.getData().getTitle());
                description_Txt_view.setText(getResponseTermsAndCondition.getData().getDescription());

            }

            @Override
            public void onFailure(Call<GetResponseTermsAndCondition> call, Throwable t) {

            }
        });




    }
}
