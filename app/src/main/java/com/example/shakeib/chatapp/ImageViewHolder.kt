package com.example.shakeib.chatapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ImageViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var imageView = itemView.findViewById<ImageView>(R.id.imageViewRec)

}