package com.example.shakeib.chatapp

import android.content.Context
import android.opengl.Visibility
import android.provider.MediaStore
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import com.bumptech.glide.Glide

class MessageAdapter(var list: ArrayList<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val MSG_CODE = 0
    var cont:Context? = null
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        cont = p0.context
        if (p1 == MSG_CODE) {
            return MsgViewHolderSend(LayoutInflater.from(p0.context).inflate(R.layout.msg_send, p0, false))
        } else {
            return MsgViewHolderRec(LayoutInflater.from(p0.context).inflate(R.layout.msg_rec, p0, false))
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is MsgViewHolderRec) {
    //        binding(p0,p1)
            if(list[p1].imageMap == null){
                p0.msgText.text = list[p1].msg
                p0.video.visibility = View.GONE
                p0.image.visibility = View.GONE
            }

            else{
                if(list[p1].imageMap.toString().contains("image")){
                    p0.msgText.text = list[p1].msg

                    p0.image.maxHeight = -2 //wrap content
                    p0.image.maxWidth = -2 //wrap content
                    p0.image.scaleType = ImageView.ScaleType.CENTER_CROP //Center crop

                    p0.image.setImageURI(list[p1].imageMap)
                    p0.video.visibility = View.GONE

                }else if(list[p1].imageMap.toString().contains("video")){
                    p0.msgText.text = list[p1].msg
                    p0.video.visibility = View.GONE
                    Glide.with(cont).load(list[p1].imageMap).into(p0.image)

//                    p0.image.maxWidth = 200


                    p0.image.setOnClickListener {
                        p0.video.visibility = View.VISIBLE
                        p0.video.setVideoURI(list[p1].imageMap)
                        p0.video.start()
                        p0.image.visibility = View.GONE
                        p0.video.setOnCompletionListener {
                            p0.video.visibility = View.GONE
                            p0.image.visibility = View.VISIBLE
                        }
         //               p0.image.visibility = View.GONE
                    }

                }

            }


        } else if (p0 is MsgViewHolderSend) {
            if(list[p1].imageMap == null){
                p0.msgText.text = list[p1].msg
                p0.video.visibility = View.GONE
                p0.image.visibility = View.GONE
            }else{
                if(list[p1].imageMap.toString().contains("image")){
                    p0.msgText.text = list[p1].msg
                    p0.image.setImageURI(list[p1].imageMap)

                    p0.image.maxHeight = -2 //wrap content
                    p0.image.maxWidth = -2 //wrap content
                    p0.image.scaleType = ImageView.ScaleType.CENTER_CROP //Center crop


                    p0.video.visibility = View.GONE
                }else if(list[p1].imageMap.toString().contains("video")){
                    p0.msgText.text = list[p1].msg
                    Glide.with(cont).load(list[p1].imageMap).into(p0.image)



                    p0.video.visibility = View.GONE
                    p0.image.setOnClickListener {
                        p0.video.visibility = View.VISIBLE
                        p0.video.setVideoURI(list[p1].imageMap)
                        p0.video.start()
                        p0.image.visibility = View.GONE
                        p0.video.setOnCompletionListener {
                            p0.video.visibility = View.GONE
                            p0.image.visibility = View.VISIBLE
                        }
                    //    p0.image.visibility = View.GONE
                    }
                }
            }

        }
    }

    private fun binding(p0:RecyclerView.ViewHolder, p1:Int){

    }

    override fun getItemViewType(position: Int): Int {
        return list[position].sender
    }
}