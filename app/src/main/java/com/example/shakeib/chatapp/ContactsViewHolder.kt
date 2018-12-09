package com.example.shakeib.chatapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ContactsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var image = itemView.findViewById<ImageView>(R.id.messageUserIcon)
    var name = itemView.findViewById<TextView>(R.id.userNameMessage)
    var envelop = itemView.findViewById<ImageView>(R.id.envelop)
}