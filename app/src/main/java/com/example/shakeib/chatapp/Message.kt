package com.example.shakeib.chatapp

import android.graphics.Bitmap
import android.net.Uri

class Message(){
    var msg:String = ""
    var sender:Int = 0
    var imageMap: Uri? = null

    constructor(msg:String, sender:Int, imageMap:Uri?):this(){
        this.msg = msg
        this.sender = sender
        this.imageMap = imageMap
    }
}