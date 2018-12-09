package com.example.shakeib.chatapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    var cont:Context? = null
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        cont = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_profile, container, false)

        v.findViewById<ImageView>(R.id.imageProfile).setImageResource(GlobalData.imageId)
        v.findViewById<TextView>(R.id.nameProfile).text = GlobalData.userName

        var temp = v.findViewById<TextView>(R.id.userNameActive).text
        temp = temp.toString() + GlobalData.userName

        v.findViewById<TextView>(R.id.userNameActive).text = temp

        v.findViewById<Button>(R.id.signOut).setOnClickListener {
            val i = Intent(cont,LoginActivity::class.java)
            startActivity(i)
        }

        return v
    }
}
