package com.example.reezkyillma.kotlindua

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class Login : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnlogin.setOnClickListener {
            val username = username.text.toString().trim()
            val password = password.text.toString().trim() //get text
            handleLogin(username,password)
        }

        tv_member.setOnClickListener {
            startActivity(intentFor<Register>())
        }

    }
    //membuat functionatau method untuk handleLogin
    private fun handleLogin(username : String, password : String) {
        info { "data username : $username, data password : $password" } //Log i jika ditulis dijavaa
        if (username.equals("test") && password.equals("test123")){
            toast("Welcome Aboard $username")
        } else {
            alert(title = "Warning", message = "Password atau Username salah"){
                positiveButton(buttonText = "OK"){
                }
                isCancelable = false
            }.show()
        }

    }
}
