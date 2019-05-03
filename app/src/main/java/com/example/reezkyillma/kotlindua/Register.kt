package com.example.reezkyillma.kotlindua

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_regtister.setOnClickListener {
            val fullname = et_fullname.text.toString().trim()
            val username = et_usernameregis.text.toString().trim()
            val password = et_passwordregis.text.toString().trim()

            handleRegister(fullname,username,password)

        }

    }
    private fun handleRegister(fullname : String, username : String, password : String){
        info { "fullname  : $fullname \n username : $username password : $password" }

        when{
            fullname.isEmpty() -> toast("Fullname is Empty")
            username.isEmpty() -> toast("Username is Empty")
            password.isEmpty() -> toast("Password is Empty")

            else -> alert ( title = "Register", message = "New Account has been already" ){
                positiveButton(buttonText = "OK"){
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
        }
    }

}
