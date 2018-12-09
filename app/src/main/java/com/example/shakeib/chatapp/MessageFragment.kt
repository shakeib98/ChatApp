package com.example.shakeib.chatapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MessageFragment : Fragment() {

    var cont: Context? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        cont = context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_message, container, false)
        val rView = v.findViewById<RecyclerView>(R.id.recyclerViewContacts)
        rView.layoutManager = LinearLayoutManager(cont)
        rView.adapter = ContactListAdapter(cont!!,GlobalData.contact,::newActivity)
        // Inflate the layout for this fragment

        return v
    }

    fun newActivity(){
        val i = Intent(cont,MessageActivity::class.java)
        startActivity(i)
    }


}
