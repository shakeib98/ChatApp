package com.example.shakeib.chatapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        signIn.setOnClickListener {
            if(checkNullOrEmpty()){
                if(checkEmailExist()){
                    if(checkPWExist()){
                        val temp = GlobalData.userList.find { it.email == emailTextSignIn.text.toString() }
                        GlobalData.userName = temp!!.name
                        GlobalData.imageId = temp!!.imageId

                        val i = Intent(this,MainActivity::class.java)
                        startActivity(i)
                        finish()
                    }
                }
            }
        }

        signUp.setOnClickListener {
            val i = Intent(this,SignUpActivity::class.java)
            startActivity(i)
        }
    }

    private fun checkNullOrEmpty():Boolean{
        if(emailTextSignIn.text.isNullOrEmpty()){
            layoutEmailSignIn.error = "Please enter email"
            return false
        }
        if(pwTextSignIn.text.isNullOrEmpty()){
            layoutPWSignIn.error = "Please enter password"
            return false
        }

        return true
    }

    private fun checkEmailExist():Boolean{
        if(GlobalData.userList.contains(GlobalData.userList.find { it.email == emailTextSignIn.text.toString()})) return true
        layoutEmailSignIn.error = "Email not valid!"
        emailTextSignIn.text!!.clear()
        pwTextSignIn.text!!.clear()
        return false
    }

    private fun checkPWExist():Boolean{
        if(GlobalData.userList.contains(GlobalData.userList.find { it.email == emailTextSignIn.text.toString() && it.pw == pwTextSignIn.text.toString()})) return true
        layoutPWSignIn.error = "Password is not Correct"
        pwTextSignIn.text!!.clear()
        return false
    }
}
