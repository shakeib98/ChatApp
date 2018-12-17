package com.example.shakeib.chatapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //To declare global data to use it further
        GlobalData.userList.add(User("Shakeib", "shakeib98@outlook.com", "12345", R.drawable.face))
        GlobalData.userList.add(User("Shahrukh", "shahrukh97@outlook.com", "12345", R.drawable.face))

        GlobalData.contact.add(Contacts("Osama", R.drawable.face))
        GlobalData.contact.add(Contacts("Atif", R.drawable.face))
        GlobalData.contact.add(Contacts("Hamza", R.drawable.face))
        GlobalData.contact.add(Contacts("Rao", R.drawable.face))
        GlobalData.contact.add(Contacts("Saif", R.drawable.face))
        GlobalData.contact.add(Contacts("Huzaifa", R.drawable.face))
        GlobalData.contact.add(Contacts("Jahanzaib", R.drawable.face))
        GlobalData.contact.add(Contacts("Usama", R.drawable.face))
        GlobalData.contact.add(Contacts("Arbaz", R.drawable.face))
        GlobalData.contact.add(Contacts("Ishaaq", R.drawable.face))
        GlobalData.contact.add(Contacts("Shakeib", R.drawable.face))
        GlobalData.contact.add(Contacts("Shaida", R.drawable.face))

        if (!GlobalData.animation) {
            signIn.visibility = View.GONE
            signUp.visibility = View.GONE
            layoutEmailSignIn.visibility = View.GONE
            layoutPWSignIn.visibility = View.GONE
        }

        val animation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation)
        val animationTwo = AnimationUtils.loadAnimation(this, R.anim.alpha_anim_two)

        if(!GlobalData.animation){
            imgLogin.startAnimation(animation)
        }

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationEnd(animation: Animation?) {
                if(!GlobalData.animation){
                    signIn.visibility = View.VISIBLE
                    signIn.startAnimation(animationTwo)
                    signUp.visibility = View.VISIBLE
                    signUp.startAnimation(animationTwo)
                    layoutEmailSignIn.visibility = View.VISIBLE
                    layoutEmailSignIn.startAnimation(animationTwo)
                    layoutPWSignIn.visibility = View.VISIBLE
                    layoutPWSignIn.startAnimation(animationTwo)

                    GlobalData.animation = true
                }

            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })


        signIn.setOnClickListener {
            if (checkNullOrEmpty()) {
                if (checkEmailExist()) {
                    if (checkPWExist()) {
                        val temp = GlobalData.userList.find { it.email == emailTextSignIn.text.toString() }
                        GlobalData.userName = temp!!.name
                        GlobalData.imageId = temp!!.imageId

                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                        finish()
                    }
                }
            }
        }

        signUp.setOnClickListener {
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }
    }

    private fun checkNullOrEmpty(): Boolean {
        if (emailTextSignIn.text.isNullOrEmpty()) {
            layoutEmailSignIn.error = "Please enter email"
            return false
        }
        if (pwTextSignIn.text.isNullOrEmpty()) {
            layoutPWSignIn.error = "Please enter password"
            return false
        }

        return true
    }

    private fun checkEmailExist(): Boolean {
        if (GlobalData.userList.contains(GlobalData.userList.find { it.email == emailTextSignIn.text.toString() })) return true
        layoutEmailSignIn.error = "Email not valid!"
        emailTextSignIn.text!!.clear()
        pwTextSignIn.text!!.clear()
        return false
    }

    private fun checkPWExist(): Boolean {
        if (GlobalData.userList.contains(GlobalData.userList.find { it.email == emailTextSignIn.text.toString() && it.pw == pwTextSignIn.text.toString() })) return true
        layoutPWSignIn.error = "Password is not Correct"
        pwTextSignIn.text!!.clear()
        return false
    }
}
