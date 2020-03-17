package com.t.meditationapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.t.meditationapp.R
import kotlinx.android.synthetic.main.tool_bar_two.*

class FinicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finicial)
        img_back_two.setOnClickListener(View.OnClickListener {

            finish()
        })
    }
}
