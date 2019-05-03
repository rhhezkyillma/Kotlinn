package com.example.reezkyillma.kotlindua

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_after_login.*

class AfterLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)


        val data = intent.getStringExtra("kode")

        tv_usernameafterlogin.setText(data)



    }
}
