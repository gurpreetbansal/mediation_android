package com.t.meditationapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.myapplication.fragment.AccountFragment
import com.t.meditationapp.R
import kotlinx.android.synthetic.main.account_two_fragment.*

class AccountSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_two_fragment)
        img_account_back.setOnClickListener(View.OnClickListener {
           finish()
        })

    }
}
