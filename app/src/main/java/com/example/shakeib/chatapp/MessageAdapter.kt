package com.example.shakeib.chatapp

import android.opengl.Visibility
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MessageAdapter(var list: ArrayList<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val MSG_CODE = 0
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        if (p1 == MSG_CODE) {
            return MsgViewHolderSend(LayoutInflater.from(p0.context).inflate(R.layout.msg_send, p0, false))
        } else {
            return MsgViewHolderRec(LayoutInflater.from(p0.context).inflate(R.layout.msg_rec, p0, false))
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is MsgViewHolderRec) {
            p0.msgText.text = list[p1].msg
            p0.image.setImageBitmap(list[p1].imageMap)

        } else if (p0 is MsgViewHolderSend) {
            p0.msgText.text = list[p1].msg
            p0.image.setImageBitmap(list[p1].imageMap)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].sender
    }
}