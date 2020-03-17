package com.t.meditationapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myapplication.fragment.AccountFragment
import com.t.meditationapp.R
import com.t.meditationapp.adapter.NotificationAdapter
import kotlinx.android.synthetic.main.nitification_fragment.*

class NotificationActivity : AppCompatActivity() {
    val group: ArrayList<String> = ArrayList()
    val notification: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nitification_fragment)
        img_notification_back.setOnClickListener(View.OnClickListener {
            finish()
        })
        recyclerview_notification.layoutManager =
            LinearLayoutManager(this@NotificationActivity)
        // Access the RecyclerView Adapter and load the data into it
        recyclerview_notification.adapter = NotificationAdapter(notification, this@NotificationActivity)
        addlist()
    }
    fun addlist() {
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")
        notification.add("June 2,2019, 07:00")

    }
}
