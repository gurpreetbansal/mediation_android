package com.t.meditationapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import android.util.Log
import android.view.View
import com.sidegig.Interface.APIService
import com.t.meditationapp.R
import com.t.meditationapp.utilityClasses.ProgressDialog
import kotlinx.android.synthetic.main.terms_and_conditions_fragment.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import android.webkit.WebSettings
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.annotation.TargetApi
import android.widget.Toast
import android.webkit.WebViewClient
import android.app.Activity
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T









class Terms_And_Conditions_Acxtivity : AppCompatActivity() {
    var mAPIService: APIService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.terms_and_conditions_fragment)


        img_back_terms.setOnClickListener(View.OnClickListener {
            finish()
        })



//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.loadUrl("https://clientstagingdev.com/meditation/api/auth/termsCondtions");


        //webview = WebView(this)

//        webview.getSettings().setJavaScriptEnabled(true) // enable javascript
//
//        val activity = this
//
//        webview.setWebViewClient(object : WebViewClient() {
//            override fun onReceivedError(
//                view: WebView,
//                errorCode: Int,
//                description: String,
//                failingUrl: String
//            ) {
//                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
//            }
//
//            @TargetApi(android.os.Build.VERSION_CODES.M)
//            override fun onReceivedError(
//                view: WebView,
//                req: WebResourceRequest,
//                rerr: WebResourceError
//            ) {
//                // Redirect to deprecated method, so you can use it in all SDK versions
//                onReceivedError(
//                    view,
//                    rerr.errorCode,
//                    rerr.description.toString(),
//                    req.url.toString()
//                )
//            }
//        })
//
//        webview.loadUrl("http://docs.google.com/gview?embedded=true&url="+"https://selfpause.com/terms-conditions/")
      //  setContentView(webview)
    }

}
