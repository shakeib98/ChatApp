package com.example.shakeib.chatapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : AppCompatActivity() {

    val REQ_CODE = 1
    var selectImage: Bitmap? = null
    var messageList:ArrayList<Message> = ArrayList()
    var senderId = 0
    var check:Boolean = false

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
                messageList.add(Message(text,senderId,selectImage))
                if(senderId == 0) senderId =1
                else if(senderId==1) senderId = 0
            }
            editTextMsg.text.clear()
            var lastPosition = messageList.size-1
            recViewMessages.adapter?.notifyItemInserted(lastPosition)
            recViewMessages.scrollToPosition(lastPosition)
            selectImage = null
        }

        imageSend.setOnClickListener {

            cameraIntent()

        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(data!=null){
            if(requestCode==REQ_CODE && resultCode == Activity.RESULT_OK){
                val photoUri = data.data
                selectImage = MediaStore.Images.Media.getBitmap(this.contentResolver,photoUri)
                check=true
                Toast.makeText(this, "image selected",Toast.LENGTH_SHORT).show()
                setImageMsg.visibility = View.VISIBLE
                setImageMsg.setImageBitmap(selectImage)

            }
        }else{
            Toast.makeText(this,"No image selected",Toast.LENGTH_SHORT).show()
        }

    }
    private fun cameraIntent(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, 1)

    }


}

