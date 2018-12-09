package com.example.shakeib.chatapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        //To declare global data to use it further
        GlobalData.userList.add(User("Shakeib","shakeib98@outlook.com","12345",R.drawable.face))
        GlobalData.userList.add(User("Shahrukh","shahrukh97@outlook.com","12345",R.drawable.face))

        GlobalData.contact.add(Contacts("Osama",R.drawable.face))
        GlobalData.contact.add(Contacts("Atif",R.drawable.face))
        GlobalData.contact.add(Contacts("Hamza",R.drawable.face))
        GlobalData.contact.add(Contacts("Rao",R.drawable.face))
        GlobalData.contact.add(Contacts("Saif",R.drawable.face))
        GlobalData.contact.add(Contacts("Huzaifa",R.drawable.face))
        GlobalData.contact.add(Contacts("Jahanzaib",R.drawable.face))
        GlobalData.contact.add(Contacts("Usama",R.drawable.face))
        GlobalData.contact.add(Contacts("Arbaz",R.drawable.face))
        GlobalData.contact.add(Contacts("Ishaaq",R.drawable.face))
        GlobalData.contact.add(Contacts("Shakeib",R.drawable.face))
        GlobalData.contact.add(Contacts("Shaida",R.drawable.face))

        val background = object : Thread() {
            override fun run() {
                try {
                    // Thread will sleep for 5 seconds
                    Thread.sleep((5 * 1000).toLong())
                    avi.show()

                    // After 5 seconds redirect to another intent
                    val i = Intent(baseContext, LoginActivity::class.java)
                    startActivity(i)

                    //Remove activity
                    finish()
                } catch (e: Exception) {
                }

            }


        }

        background.start()
    }
}
