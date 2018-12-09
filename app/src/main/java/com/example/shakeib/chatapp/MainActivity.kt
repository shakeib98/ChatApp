package com.example.shakeib.chatapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = FragmentViewPageAdapter(supportFragmentManager, arrayListOf(
            MessageFragment(),
            ProfileFragment()
        ))

        tabLayout.setupWithViewPager(pager)

        Toast.makeText(this,"Hello ${GlobalData.userName}",Toast.LENGTH_SHORT).show()
    }
}
