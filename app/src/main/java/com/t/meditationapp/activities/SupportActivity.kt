package com.t.meditationapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.myapplication.fragment.AccountFragment
import com.t.meditationapp.R
import kotlinx.android.synthetic.main.support_fragment.*

class SupportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.support_fragment)
        img_back_support.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}
