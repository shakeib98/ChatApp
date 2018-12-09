package com.example.shakeib.chatapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class FragmentViewPageAdapter(fragmentManager: FragmentManager, var list:ArrayList<Fragment>):FragmentPagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment = list[p0]


    override fun getCount(): Int = list.size

    override fun getPageTitle(position: Int): CharSequence? = if(position==0){
        "Messages"
    }else "Profile"
}