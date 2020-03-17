package com.t.meditationapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.t.meditationapp.R
import com.t.meditationapp.fragment.AbundanceTwoFragment
import com.t.meditationapp.fragment.HealthTwoFragment
import kotlinx.android.synthetic.main.activity_financial.*
import kotlinx.android.synthetic.main.stress_two_fragment.img_abun_stress
import kotlinx.android.synthetic.main.stress_two_fragment.img_health_stress
import kotlinx.android.synthetic.main.stress_two_fragment.img_stress_five
import kotlinx.android.synthetic.main.stress_two_fragment.img_stress_four
import kotlinx.android.synthetic.main.stress_two_fragment.img_stress_one
import kotlinx.android.synthetic.main.stress_two_fragment.img_stress_six
import kotlinx.android.synthetic.main.stress_two_fragment.img_stress_three
import kotlinx.android.synthetic.main.stress_two_fragment.img_stress_two
import kotlinx.android.synthetic.main.tool_bar_two.*

class FinancialTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_financial)
        ll_fin_finicial.setOnClickListener(View.OnClickListener {
//            val weightFragment = StressFragment.newInstance()
//            openFragment(weightFragment)
            val intent = Intent(this@FinancialTwoActivity, FinicialActivity::class.java)
            startActivity(intent)
        })


        img_back_two.setOnClickListener(View.OnClickListener {
          //  val intent = Intent(this@FinancialTwoActivity, HomeActivity::class.java)
            // val intent = Intent(this, VideocallingActivity::class.java)
            //startActivity(intent)
            finish()
        })

        img_abun_fin.setOnClickListener(View.OnClickListener {
//            val weightFragment = AbundanceTwoFragment.newInstance()
//            openFragment(weightFragment)
            val intent = Intent(this@FinancialTwoActivity, AbundanceTwoActivity::class.java)
            startActivity(intent)
        })
        img_health_fin.setOnClickListener(View.OnClickListener {
           // val weightFragment = HealthTwoFragment.newInstance()
           // openFragment(weightFragment)
            val intent = Intent(this@FinancialTwoActivity, HealthTwoActivity::class.java)
            startActivity(intent)
        })


        img_fin_one.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@FinancialTwoActivity, CreativtyAffirmationsActivity::class.java)
            startActivity(voice)
        })

        img_fin_two.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@FinancialTwoActivity, GetMore_Activity::class.java)
            startActivity(voice)
        })
        img_fin_three.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@FinancialTwoActivity, GetMore_Activity::class.java)
            startActivity(voice)
        })
        img_fin_four.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@FinancialTwoActivity, GetMore_Activity::class.java)
            startActivity(voice)
        })
        img_fin_five.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@FinancialTwoActivity, GetMore_Activity::class.java)
            startActivity(voice)
        })
        img_fin_six.setOnClickListener(View.OnClickListener {
            val voice = Intent(this@FinancialTwoActivity, GetMore_Activity::class.java)
            startActivity(voice)
        })
    }

}
