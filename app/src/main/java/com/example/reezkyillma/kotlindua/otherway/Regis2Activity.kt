package com.example.reezkyillma.kotlindua.otherway

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.reezkyillma.kotlindua.R
import org.jetbrains.anko.*

class Regis2Activity : AppCompatActivity() , AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Regis2Activity.RegisterView().setContentView(this)

        var btn: Button = findViewById(R.id.btnn)
        var fullname : EditText = findViewById(R.id.et_fullname)
        var uname: EditText = findViewById(R.id.et_usernamee)
        var password: TextView = findViewById(R.id.et_passwordd)

        btn.setOnClickListener {

            val fullname = fullname.text.toString().trim()
            val username = uname.text.toString().trim()
            val password = password.text.toString().trim()
            handleRegister(fullname,username, password)
        }
    }

    //membuat class yang akan mendesign layoutt

    class RegisterView : AnkoComponent<Regis2Activity> {
        override fun createView(ui: AnkoContext<Regis2Activity>) = with(ui) {

                verticalLayout {
                    lparams(width = matchParent, height = matchParent) {
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 20

                        textView {
                            hint = "REGISTER"
                            textSize = 25f //tipedata float
                            textColor = Color.CYAN
                            textAlignment = TextView.TEXT_ALIGNMENT_CENTER

                        }.lparams(width = matchParent, height = wrapContent) {
                            margin = 15
                        }

                        editText{
                            id = R.id.et_fullname
                            hint = "Fullname"
                            textSize = 20f
                            inputType = InputType.TYPE_CLASS_TEXT
                        }.lparams(width = matchParent, height = wrapContent) {
                            margin = 15

                        }

                        editText {
                            id = R.id.et_usernamee
                            hint = "Username"
                            textSize = 20f
                            inputType = InputType.TYPE_CLASS_TEXT
                        }.lparams(width = matchParent, height = wrapContent) {
                            margin = 15

                        }
                        editText {
                            id = R.id.et_passwordd
                            hint = "Password"
                            textSize = 20f
                            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        }.lparams(width = matchParent, height = wrapContent) {
                            margin = 15

                        }

                        button("REGISTER") {
                            id = R.id.btnn
                        }.lparams(width = wrapContent, height = wrapContent) {
                            margin = 15
                            gravity = Gravity.CENTER

                        }


                    }
                }

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
