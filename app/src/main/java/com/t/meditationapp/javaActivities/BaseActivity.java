package com.t.meditationapp.javaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.t.meditationapp.R;

import java.net.InetAddress;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

//    public void CustomDialog(Context context){
//        Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.dialog_progress);
//
//        Window window = dialog.getWindow();
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.x = 400;
//        params.y = 100;
//        dialog.getWindow().setAttributes(params);
//
//        dialog.show();
//
////        dialog_recyclerView = dialog.findViewById(R.id.dialog_sendstatus_recyclerView);
////        selected = dialog.findViewById(R.id.dialog_sendstatus_allselected);
////        unselected = dialog.findViewById(R.id.dialog_sendstatus_allunselected);
////        post = dialog.findViewById(R.id.dialog_sendstatus_post);
//    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }
}
