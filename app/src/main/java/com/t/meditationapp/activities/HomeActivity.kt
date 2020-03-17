package com.t.meditationapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.t.meditationapp.R

import com.app.myapplication.fragment.*
import kotlinx.android.synthetic.main.bottom_navi_layout.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.net.Inet4Address
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T









class HomeActivity : AppCompatActivity()/*, FragmentLifecycle*/ {

    var load_view: String = ""
    private lateinit var textMessage: TextView
//    private val onNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_lib -> {
//                  //  item.setIcon(R.drawable.lib_xtra)// to set icon programatically
////                    val extras = getIntent().getExtras()
////                    if (null != extras)
////                    {
////                        val value = extras.getString("CLICKED")
////                        Log.e("CLICKED_VALUE", "CLICKEC_VALUE" + value)
////                        if (value == "WEIGHT_LOSS") {
////                            val weightFragment = WeightFragment.newInstance()
////                            openFragment(weightFragment)
////                        }
////                        if (value == "PROFESSIONAL") {
////                            val professionalFragment = ProfessionalFragment.newInstance()
////                            openFragment(professionalFragment)
////                        }//STRESS
////                        if (value == "STRESS") {
////                            val stressFragment = StressFragment.newInstance()
////                            openFragment(stressFragment)
////                        }
////                        if (value == "RELATION") {
////                            val relationshipFragment = RelationshipFragment.newInstance()
////                            openFragment(relationshipFragment)
////                        }
////                        if (value == "ATHLETIC") {
////
////                            Toast.makeText(this@HomeActivity, "NOT AVAILABLE", Toast.LENGTH_LONG).show()
////                        }
////                        if (value == "HEALTH") {
////                            val healthFragment = HealthFragment.newInstance()
////                            openFragment(healthFragment)
////                        }
////                        if (value == "FINE") {
////                            Toast.makeText(this@HomeActivity, "NOT AVAILABLE", Toast.LENGTH_LONG).show()
////                        }
////                        if (value == "ABUN") {
////
////                            Toast.makeText(this@HomeActivity, "NOT AVAILABLE", Toast.LENGTH_LONG).show()
////                        }
////
////
////                    }
////else {
//                        val homeFragment = LibraryFragment.newInstance()
//
//                        openFragment(homeFragment)
//                   //}
//
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_soundn -> {
//                    // textMessage.setText(R.string.title_dashboard)
//                    val loanfragment = SoundFragment.newInstance()
//                    openFragment(loanfragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_record -> {
//                    // textMessage.setText(R.string.title_notifications)
//                    val meetingFragment = RecordFragment.newInstance()
//                    openFragment(meetingFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_accountt -> {
//                    //textMessage.setText(R.string.title_dashboard)
//                    val chatFragment = AccountFragment.newInstance()
//                    openFragment(chatFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//            }
//            false
//        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val homeFragment1 = LibraryFragment.newInstance()
        openFragment(homeFragment1)
        lib.setOnClickListener {
            img_bottom_lib.visibility=View.VISIBLE
            img_bottom_sound.visibility=View.INVISIBLE
            img_bottom_record.visibility=View.INVISIBLE
            img_bottom_account.visibility=View.INVISIBLE


            val homeFragment = LibraryFragment.newInstance()
            openFragment(homeFragment)

        }
        sound.setOnClickListener {
            img_bottom_lib.visibility=View.INVISIBLE
            img_bottom_sound.visibility=View.VISIBLE
            img_bottom_record.visibility=View.INVISIBLE
            img_bottom_account.visibility=View.INVISIBLE


            val homeFragment = SoundFragment.newInstance()
            openFragment(homeFragment)

        }
        record.setOnClickListener {
            img_bottom_lib.visibility=View.INVISIBLE
            img_bottom_sound.visibility=View.INVISIBLE
            img_bottom_record.visibility=View.VISIBLE
            img_bottom_account.visibility=View.INVISIBLE


            val homeFragment = RecordFragment.newInstance()
            openFragment(homeFragment)
          //  val intent = Intent(this@HomeActivity, My_RecordingActivity::class.java)
           // startActivity(intent)

        }

        account.setOnClickListener {
            img_bottom_lib.visibility=View.INVISIBLE
            img_bottom_sound.visibility=View.INVISIBLE
            img_bottom_record.visibility=View.INVISIBLE
            img_bottom_account.visibility=View.VISIBLE


            val homeFragment = AccountThreeFragment.newInstance()
            openFragment(homeFragment)

        }
       // val navView: BottomNavigationView = findViewById(R.id.nav_view)
       // navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
//        val extras = getIntent().getExtras()
//        if (null != extras)
//        {
//            val value = extras.getString("CLICKED")
//            Log.e("CLICKED_VALUE", "CLICKEC_VALUE" + value)
//            if (value == "WEIGHT_LOSS") {
//                val weightFragment = WeightFragment.newInstance()
//                openFragment(weightFragment)
//            }
//            if (value == "PROFESSIONAL") {
//                val professionalFragment = ProfessionalFragment.newInstance()
//                openFragment(professionalFragment)
//            }//STRESS
//            if (value == "STRESS") {
//                val stressFragment = StressFragment.newInstance()
//                openFragment(stressFragment)
//            }
//            if (value == "RELATION") {
//                val relationshipFragment = RelationshipFragment.newInstance()
//                openFragment(relationshipFragment)
//            }
//            if (value == "ATHLETIC") {
//
//                Toast.makeText(this@HomeActivity, "NOT AVAILABLE", Toast.LENGTH_LONG).show()
//            }
//            if (value == "HEALTH") {
//                val healthFragment = HealthFragment.newInstance()
//                openFragment(healthFragment)
//            }
//            if (value == "FINE") {
//                Toast.makeText(this@HomeActivity, "NOT AVAILABLE", Toast.LENGTH_LONG).show()
//            }
//            if (value == "ABUN") {
//
//                Toast.makeText(this@HomeActivity, "NOT AVAILABLE", Toast.LENGTH_LONG).show()
//            }
//
//
//        }
//        else {

        img_bottom_lib.visibility=View.VISIBLE
        img_bottom_sound.visibility=View.INVISIBLE
        img_bottom_record.visibility=View.INVISIBLE
        img_bottom_account.visibility=View.INVISIBLE
            val homeFragment = LibraryFragment.newInstance()
            openFragment(homeFragment)
      //  }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

//    override fun onBackPressed() {
//        if (fragmentManager.backStackEntryCount > 0) {
//            fragmentManager.popBackStack()
//        } else {
//            super.onBackPressed()
//        }
//    }



//    override fun onBackPressed() {
//
//        Log.e("entrycount : ", "" + getSupportFragmentManager().getBackStackEntryCount());
//
//        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
//            fragmentManager.popBackStack()
//            // only show dialog while there's back stack entry
////            AlertDialog.show(getSupportFragmentManager(), "ConfirmDialogFragment");
//        //    Toast.makeText(HomeActivity@ this, "FINISH", Toast.LENGTH_LONG).show()
//
//          //  val intent=Intent(this@HomeActivity,LogOut_Activity::class.java)
//         //   startActivity(intent)
//
//        } else if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
//
//            // or just go back to main activity
//            super.onBackPressed();
//              val intent=Intent(this@HomeActivity,LogOut_Activity::class.java)
//               startActivity(intent)
//        }
//    }


//    override fun onBackPressed() {
//        if (fragmentManager.backStackEntryCount == 0) {
//            this.finish()
//           // val intent=Intent(this@HomeActivity,LogOut_Activity::class.java)
//            //   startActivity(intent)
//        } else {
//            fragmentManager.popBackStack()
//        }
//    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
           // finish()
                        val intent=Intent(this@HomeActivity,LogOut_Activity::class.java)
               startActivity(intent)
        }
    }


}