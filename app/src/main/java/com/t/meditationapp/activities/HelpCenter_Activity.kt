package com.t.meditationapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.t.meditationapp.R
import kotlinx.android.synthetic.main.help_activity.*
import kotlinx.android.synthetic.main.help_center_activity.*

class HelpCenter_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.help_activity)
        img_back_help.setOnClickListener(View.OnClickListener {
            finish()
        })

//        img_back_help.setOnClickListener(View.OnClickListener {
//            // getActivity()!!.finish();
//            if (getFragmentManager()!!.getBackStackEntryCount() != 0) {
//                getFragmentManager()!!.popBackStack();
//            }
//        })
//

    }
}
