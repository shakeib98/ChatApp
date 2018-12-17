package com.example.shakeib.chatapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView

class MsgViewHolderRec(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var msgText = itemView.findViewById<TextView>(R.id.msgRecTv)
    var image = itemView.findViewById<ImageView>(R.id.imageViewRec)
    var video = itemView.findViewById<VideoView>(R.id.videoViewRec)

}