package com.example.shakeib.chatapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView

class MsgViewHolderSend(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var msgText = itemView.findViewById<TextView>(R.id.msgSendTv)
    var image = itemView.findViewById<ImageView>(R.id.imageViewSend)
    var video = itemView.findViewById<VideoView>(R.id.videoViewSend)



}