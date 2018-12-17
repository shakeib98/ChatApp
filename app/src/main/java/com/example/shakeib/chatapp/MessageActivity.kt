package com.example.shakeib.chatapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.ThumbnailUtils
import android.net.Uri
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : AppCompatActivity() {

    val REQ_CODE = 1
    var selectMedia: Uri? = null
    var messageList:ArrayList<Message> = ArrayList()
    var senderId = 0
    var check:Boolean = false
   // var selectVideo:Uri? = null
    var video = false
    var image = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        recViewMessages.layoutManager = LinearLayoutManager(this)
        recViewMessages.adapter = MessageAdapter(messageList)

        setImageMsg.visibility = View.GONE

        msgSendBtn.setOnClickListener {
            setImageMsg.visibility = View.GONE

            var text = editTextMsg.text.toString()
            if(!text.isNullOrEmpty()){
                messageList.add(Message(text,senderId,selectMedia))
                //changes with new code
                if(senderId == 0) senderId =1
                else if(senderId==1) senderId = 0

                editTextMsg.text.clear()
                var lastPosition = messageList.size-1
                recViewMessages.adapter?.notifyItemInserted(lastPosition)
                recViewMessages.scrollToPosition(lastPosition)
                selectMedia = null

            }

        }

        imageSend.setOnClickListener {

            cameraIntent()

        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(data!=null){
            if(requestCode==REQ_CODE && resultCode == Activity.RESULT_OK){
                val photoUri = data.data
                if(photoUri.toString().contains("image")){
                 //   selectImage = MediaStore.Images.Media.getBitmap(this.contentResolver,photoUri)
                    Toast.makeText(this, "image selected",Toast.LENGTH_SHORT).show()
                    setImageMsg.visibility = View.VISIBLE
                    setImageMsg.setImageURI(photoUri)
                    selectMedia = photoUri
                //    videoView.visibility = View.GONE
                    image = true
                }else if(photoUri.toString().contains("video")){
                    selectMedia = photoUri
                    Toast.makeText(this, "video selected",Toast.LENGTH_SHORT).show()
                    //thumbnail
                    Glide.with(this@MessageActivity).load(photoUri).into(setImageMsg)
                    setImageMsg.visibility = View.VISIBLE
                    video = true

                }




            }
        }else{
            Toast.makeText(this,"No image selected",Toast.LENGTH_SHORT).show()
        }

    }
    private fun cameraIntent(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/* video/*"
        startActivityForResult(intent, 1)

    }


}

