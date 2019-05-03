package com.example.reezkyillma.kotlindua

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_login.setOnClickListener {


            val username = et_username.text.toString().trim()
             val password = et_password.text.toString().trim() //get text
            handleLogin(username,password)
        }

        tv_ca.setOnClickListener {
            startActivity(intentFor<Register>("test" to "x"))
        }

    }
    //membuat functionatau method untuk handleLogin
    public fun handleLogin(username : String, password : String) {

        info { "data username : $username, data password : $password" } //Log i jika ditulis dijavaa
        if (username.equals("test") && password.equals("test123")){
            toast("Welcome Aboard $username")
            startActivity(intentFor<AfterLogin>("kode" to username))
        } else {
            alert(title = "Warning", message = "Password atau Username salah"){
                positiveButton(buttonText = "OK"){
            }
         isCancelable = false
            }.show()
        }

//        debug {  }
//        info {  }
//        error {  }

    }
}
