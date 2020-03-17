package com.t.meditationapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.t.meditationapp.R
import com.t.meditationapp.activities.WeighTwoActivity
import kotlinx.android.synthetic.main.tool_bar_two.*


class WeightFragment : Fragment()
{
    val group: ArrayList<String> = ArrayList()
    /* override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
         inflater.inflate(R.layout.fragment_cart, container, false)
 */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //   var rootView = inflater!!.inflate(R.layout.fragment_home, container, false)
        var rootView = inflater!!.inflate(R.layout.weight_fragment, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)


//        ll_first.setOnClickListener(View.OnClickListener {
//            val weightFragment = CreativtyAffirmationsTwoFragment.newInstance()
//            openFragment(weightFragment)
//        })
        img_back_two.setOnClickListener(View.OnClickListener {
            val voice = Intent(activity, WeighTwoActivity::class.java)
            startActivity(voice)
        })
    }

    companion object {
        fun newInstance(): WeightFragment = WeightFragment()
    }
    private fun openFragment(fragment: Fragment) {
        val transaction =activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}
