package com.example.shakeib.chatapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ContactListAdapter(var cont: Context, var list:ArrayList<Contacts>, var newActivity:()->Unit) : RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactsViewHolder = ContactsViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.contacts_layout,p0,false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: ContactsViewHolder, p1: Int) {
        p0.image.setImageResource(list[p1].imageId)
        p0.name.text = list[p1].name
        p0.envelop.setImageResource(R.drawable.envelop)

        p0.itemView.setOnClickListener {
            newActivity()
        }
    }
}