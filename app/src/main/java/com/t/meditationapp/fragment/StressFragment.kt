package com.t.meditationapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.t.meditationapp.R
import com.t.meditationapp.activities.CreativtyAffirmationsActivity
import kotlinx.android.synthetic.main.stress_fragment.*
import kotlinx.android.synthetic.main.tool_bar_two.*


class StressFragment : Fragment()
{
    val group: ArrayList<String> = ArrayList()
    /* override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
         inflater.inflate(R.layout.fragment_cart, container, false)
 */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //   var rootView = inflater!!.inflate(R.layout.fragment_home, container, false)
        var rootView = inflater!!.inflate(R.layout.stress_fragment, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        ll_first.setOnClickListener(View.OnClickListener {
            val voice = Intent(activity, CreativtyAffirmationsActivity::class.java)
            startActivity(voice)
//            val intent = Intent(context, WeightTwoFragment::class.java)
//
//            startActivity(intent)
        })
        img_back_two.setOnClickListener(View.OnClickListener {
            val weightFragment = StressTwoFragment.newInstance()
            openFragment(weightFragment)
        })
    }

    companion object {
        fun newInstance(): StressFragment = StressFragment()
    }
    private fun openFragment(fragment: Fragment) {
        val transaction =activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}
