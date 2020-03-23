package com.t.meditationapp.javaActivities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.tasks.Task;
import com.t.meditationapp.Api.ApiInterface;
import com.t.meditationapp.Api.RetrofitClientInstance;
import com.t.meditationapp.Custom_Widgets.CustomBoldEditText;
import com.t.meditationapp.Custom_Widgets.CustomBoldtextView;
import com.t.meditationapp.ModelClasses.LoginModelClass;
import com.t.meditationapp.ModelClasses.LoginSendData;
import com.t.meditationapp.R;
import com.t.meditationapp.activities.HomeActivity;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityNew extends BaseActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = null;
    com.t.meditationapp.Custom_Widgets.CustomBoldEditText ed_password, ed_email;
    com.t.meditationapp.Custom_Widgets.CustomRegularTextView btn_login;
    CustomBoldtextView btn_signup, txt_forgot_password;
    ApiInterface apiInterface;
    private LoginSendData loginSendData = new LoginSendData();


    String email_txt, password_txt, device_type = "Android";
    ProgressDialog progressDialog;

    private SignInButtonImpl signInButton;
    private ConstraintLayout loginActivity_ll_google;
    GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 1;
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_email = findViewById(R.id.login__email);
        ed_password = findViewById(R.id.login__password);
        btn_login = findViewById(R.id.login__txt_log_in);
        btn_signup = findViewById(R.id.txt_sign_up);
        txt_forgot_password = findViewById(R.id.txt_forgot_password);
        loginActivity_ll_google = findViewById(R.id.loginActivity_ll_google);

        signInButton = findViewById(R.id.login_button_google);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait......");

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivityNew.this, SignupActivityNew.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_txt = ed_email.getText().toString();
                password_txt = ed_password.getText().toString();
                loginSendData.setEmail(email_txt);
                loginSendData.setPassword(password_txt);
                loginSendData.setDeviceToken(UUID.randomUUID().toString());
                loginSendData.setDeviceType(device_type);

                if (validateName(email_txt, ed_email, "email is required")) {
                    return;
                }
                if (validateName(password_txt, ed_password, "password is required")) {
                    return;
                }
                if (validatePassword(password_txt, ed_password, "pssword must be atleast 6 characters")) {
                    return;
                }
                showDialog();
//                    Log.e("email+", loginSendData.getEmail());
                retrofitData();
            }
        });

        txt_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivityNew.this, ForgetPasswordActivity.class));


            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

//        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail().build();
//
//        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();

        loginActivity_ll_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
//                startActivityForResult(intent, REQ_CODE);
//                showDialog();
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, REQ_CODE);
            }
        });


    }

    public void retrofitData() {
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<LoginModelClass> call = apiInterface.login(loginSendData);
        call.enqueue(new Callback<LoginModelClass>() {
            @Override
            public void onResponse(@NotNull Call<LoginModelClass> call, @NotNull Response<LoginModelClass> response) {
                if (response.isSuccessful()) {
                    LoginModelClass resource = response.body();
                    assert resource != null;
                    if (resource.getSuccess()) {
                        String code = resource.getCode();
                        String msg = resource.getMessages();

                        SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("user_id", resource.getData().getUserId());
                        editor.apply();

                        startActivity(new Intent(LoginActivityNew.this, HomeActivity.class));
                        Toast.makeText(LoginActivityNew.this, msg, Toast.LENGTH_SHORT).show();

                        hideDialog();

                        Log.e("Success Response++++", code + " " + msg);
                    } else {
                        Toast.makeText(LoginActivityNew.this, resource.getMessages(), Toast.LENGTH_SHORT).show();
                        hideDialog();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginModelClass> call, Throwable t) {
                Log.e("Failure Response++++", t.getMessage());
                Toast.makeText(LoginActivityNew.this, t.toString(), Toast.LENGTH_SHORT).show();

                hideDialog();
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

    public void showDialog() {

        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Toast.makeText(this, "" + connectionResult, Toast.LENGTH_SHORT).show();
        hideDialog();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == REQ_CODE) {
//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            handleSignInResult(result);
//        }
//
//
//    }
//
//    private void handleSignInResult(GoogleSignInResult result) {
//        if (result.isSuccess()) {
//            gotoProfile();
//        } else {
//            Toast.makeText(getApplicationContext(), "Sign in cancel", Toast.LENGTH_LONG).show();
//            hideDialog();
//        }
//    }
//    private void gotoProfile () {
//        Intent intent = new Intent(LoginActivityNew.this, HomeActivity.class);
//        startActivity(intent);
//        hideDialog();
//    }

        if (requestCode == REQ_CODE) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
//            updateUI(account);

            Toast.makeText(this, "Successfully registered"+account, Toast.LENGTH_SHORT).show();
            hideDialog();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
            hideDialog();
        }
    }
}

// Already google sign in
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);
//        if (alreadyloggedAccount != null) {
//            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
//            onLoggedIn(alreadyloggedAccount);
//        } else {
//            Log.d(TAG, "Not logged in");
//        }
//    }