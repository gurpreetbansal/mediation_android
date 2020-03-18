package com.t.meditationapp.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.t.meditationapp.R
import com.t.meditationapp.javaActivities.LoginActivityNew
import kotlinx.android.synthetic.main.quit_activity.*

class LogOut_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quit_activity)

        txt_yes.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@LogOut_Activity, LoginActivityNew::class.java)
            startActivity(voice)
        })
        txt_no.setOnClickListener(View.OnClickListener {
            finish()
        })
        txt_help_center_quit.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@LogOut_Activity, HelpCenter_Activity::class.java)
            startActivity(voice)
        })
    }
}
