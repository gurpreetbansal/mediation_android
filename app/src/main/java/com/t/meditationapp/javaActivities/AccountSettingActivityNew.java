package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.Custom_Widgets.CustomRegularEditText;
import com.t.meditationapp.ModelClasses.ChangePasswordResponse;
import com.t.meditationapp.ModelClasses.GetEditProfileResponse;
import com.t.meditationapp.ModelClasses.GetProfileResponse;
import com.t.meditationapp.R;
import com.t.meditationapp.utilityClasses.ProgressDialog;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountSettingActivityNew extends BaseActivity {
    ImageView btn_back;
    String email_txt, password_txt, name_txt, userID;
    ApiInterface apiInterface;
    String mypreference = "mypref", user_id = "user_id";
    CustomBoldtextView tv_firstname, tv_lastname, tv_email, tv_password, firstname_edit, lastname_edit, email_edit, password_change;
    GetProfileResponse resource;
    AppCompatButton done, change_password;
    RelativeLayout progress_rl;
    CustomRegularEditText old_password, new_password;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_two_fragment);

        SharedPreferences pref = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userID = pref.getString(user_id, "");

        btn_back = findViewById(R.id.img_account_back);
        tv_firstname = findViewById(R.id.account_two_frag__first_name);
        tv_lastname = findViewById(R.id.account_two_frag__last_name);
        tv_email = findViewById(R.id.account_two_frag__email);
        tv_password = findViewById(R.id.account_two_frag__password);
        firstname_edit = findViewById(R.id.account_two_frag__first_name_edit);
        lastname_edit = findViewById(R.id.account_two_frag__last_name_edit);
        email_edit = findViewById(R.id.account_two_fragment__email_name_edit);
        done = findViewById(R.id.account_two_frag__done);
        progress_rl = findViewById(R.id.account_two_frag__prog_rl);
        password_change = findViewById(R.id.account_two_frag__password_change);

        firstname_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("First Name", tv_firstname);
            }
        });

        lastname_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Last Name", tv_lastname);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (isNetworkConnected()) {
            progress_rl.setVisibility(View.VISIBLE);
            retrofitGetProfileData(userID);
        } else {
            Toast.makeText(this, "Internet not connected", Toast.LENGTH_SHORT).show();
        }

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofitEditProfileData(userID, tv_firstname.getText().toString(), tv_lastname.getText().toString());
            }
        });

        password_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordDialog();
            }
        });

    }

    public void retrofitGetProfileData(String userID) {
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<GetProfileResponse> call = apiInterface.getProfile(userID);

        call.enqueue(new Callback<GetProfileResponse>() {
            @Override
            public void onResponse(Call<GetProfileResponse> call, Response<GetProfileResponse> response) {
                if (response.isSuccessful()) {
                    resource = response.body();
                    assert resource != null;
                    Log.e("success", resource.getMessages());
                    if (resource.getSuccess()) {
//                        Log.e("success", resource.getData().getFirstName() + " " + resource.getData().getEmail() + " " + resource.getData().getPassword());
                        tv_firstname.setText(resource.getData().getFirstName());
                        tv_lastname.setText(resource.getData().getLastName());
                        tv_email.setText(resource.getData().getEmail());
                        progress_rl.setVisibility(View.GONE);

                    } else {
                        Toast.makeText(AccountSettingActivityNew.this, resource.getMessages(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<GetProfileResponse> call, Throwable t) {
                Log.e("Failure Response++++", t.getMessage());
                Toast.makeText(AccountSettingActivityNew.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void retrofitEditProfileData(final String userID, final String firstName, final String lastName) {
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<GetEditProfileResponse> call = apiInterface.editProfile(userID, firstName, lastName);
        call.enqueue(new Callback<GetEditProfileResponse>() {
            @Override
            public void onResponse(@NotNull Call<GetEditProfileResponse> call, @NotNull Response<GetEditProfileResponse> response) {
                if (response.isSuccessful()) {
                    GetEditProfileResponse getEditProfileresources = response.body();

                    assert getEditProfileresources != null;
                    if (getEditProfileresources.getSuccess()) {
                        resource.getData().setFirstName(firstName);
                        resource.getData().setLastName(lastName);
                        Toast.makeText(AccountSettingActivityNew.this, getEditProfileresources.getMessages(), Toast.LENGTH_SHORT).show();
//                        Log.e("data1", resource.getData().getFirstName() + " " + resource.getData().getLastName());
//                        Log.e("data2", getEditProfileresources.getData().getFirstName() + " " + getEditProfileresources.getData().getLastName());
                    } else {
                        Toast.makeText(AccountSettingActivityNew.this, getEditProfileresources.getMessages(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AccountSettingActivityNew.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetEditProfileResponse> call, Throwable t) {
                Toast.makeText(AccountSettingActivityNew.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void retrofitPasswordChange(final String userID, final String oldPassword, final String newPassword) {
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Log.e("put",userID+" "+oldPassword+" "+newPassword);
        Call<ChangePasswordResponse> call = apiInterface.changePassword(userID, oldPassword, newPassword);
        call.enqueue(new Callback<ChangePasswordResponse>() {
            @Override
            public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                if (response.isSuccessful()) {
                    ChangePasswordResponse changePasswordResource = response.body();
                    if (changePasswordResource.getSuccess()) {
                        dialog.dismiss();
                        Toast.makeText(AccountSettingActivityNew.this, changePasswordResource.getMessages(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AccountSettingActivityNew.this, changePasswordResource.getMessages(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AccountSettingActivityNew.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
                Toast.makeText(AccountSettingActivityNew.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void dialog(final String name, final CustomBoldtextView textview) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(AccountSettingActivityNew.this);
        builder.setTitle(name);

        final EditText input = new EditText(AccountSettingActivityNew.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textview.setText(input.getText().toString());
            }
        });
        builder.show();
    }

    public void passwordDialog() {

        dialog = new Dialog(AccountSettingActivityNew.this);
        dialog.setContentView(R.layout.dialog_password_change);

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.x = 400;
        params.y = 100;
        dialog.getWindow().setAttributes(params);

        dialog.show();

        old_password = dialog.findViewById(R.id.dialog_password_change_oldpassword);
        new_password = dialog.findViewById(R.id.dialog_password_change_newpassword);
        change_password = dialog.findViewById(R.id.dialog_password_change_change_password);

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofitPasswordChange(userID, old_password.getText().toString(), new_password.getText().toString());
            }
        });

    }
}
