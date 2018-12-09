package com.example.shakeib.chatapp

import android.graphics.Bitmap
import android.net.Uri

class Message(){
    var msg:String = ""
    var sender:Int = 0
    var imageMap: Bitmap? = null

    constructor(msg:String, sender:Int, imageMap:Bitmap?):this(){
        this.msg = msg
        this.sender = sender
        this.imageMap = imageMap
    }
}