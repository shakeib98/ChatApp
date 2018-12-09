package com.example.shakeib.chatapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpConfirm.setOnClickListener {
            if(checkNullOrEmpty()){
                if(matchPasswrod()){
                    if(emailDoesNotExist()){
                        Toast.makeText(this,"Account Created ${userNameTextSignUp.text.toString()}",Toast.LENGTH_SHORT).show()
                        GlobalData.userList.add(User(userNameTextSignUp.text.toString(),emailTextSignUp.text.toString(),pwTextSignUp.text.toString(),R.drawable.login_defualt))
                        val i = Intent(this,LoginActivity::class.java)
                        startActivity(i)
                        finish()
                    }
                }
            }
        }
    }

    private fun checkNullOrEmpty():Boolean{
        if(userNameTextSignUp.text.isNullOrEmpty()){
            layoutUserNameSignUp.error = "Please enter User name"
            return false
        }

        if(emailTextSignUp.text.isNullOrEmpty()){
            layoutEmailSignUp.error = "Please enter email"
            return false
        }
        if(pwTextSignUp.text.isNullOrEmpty()){
            layoutPWSignUp.error = "Please enter password"
            return false
        }

        if(confirmPWTextSignUp.text.isNullOrEmpty()){
            layoutConfirmPWSignUp.error = "Please enter Confirm Password"
            return false
        }



        return true
    }

    private fun matchPasswrod():Boolean{
        if(pwTextSignUp.text.toString().equals(confirmPWTextSignUp.text.toString())) return true
        else{
            layoutConfirmPWSignUp.error = "Password Doesn't match!"
            confirmPWTextSignUp.text!!.clear()
            return false
        }
    }

    private fun emailDoesNotExist():Boolean{
        val email = GlobalData.userList.filter { it.email == emailTextSignUp.text.toString() }
        if(email.size == 0) {
            return true
        }else{
            layoutEmailSignUp.error = "Account Exist"
            return false

        }
    }
}
