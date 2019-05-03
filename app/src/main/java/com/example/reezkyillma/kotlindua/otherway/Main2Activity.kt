package com.example.reezkyillma.kotlindua.otherway

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.reezkyillma.kotlindua.AfterLogin
import com.example.reezkyillma.kotlindua.R
import com.example.reezkyillma.kotlindua.Register
import org.jetbrains.anko.*

class Main2Activity : AppCompatActivity() , AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)
        var btn: Button = findViewById(R.id.btnn)
        var uname: EditText = findViewById(R.id.et_usernamee)
        var password: TextView = findViewById(R.id.et_passwordd)
        var regis: TextView = findViewById(R.id.tv_caa)
        btn.setOnClickListener {



            val username = uname.text.toString().trim()
            val password = password.text.toString().trim()
            handleLogin(username, password)
        }

        regis.setOnClickListener {
            startActivity(intentFor<Regis2Activity>())
        }
    }

    //membuat class yang akan mendesign layoutt

    class LoginView : AnkoComponent<Main2Activity> {
        override fun createView(ui: AnkoContext<Main2Activity>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.abuabu
                }

                verticalLayout {
                    lparams(width = matchParent, height = wrapContent) {
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 20

                        textView {
                            hint = "LOGIN"
                            textSize = 25f //tipedata float
                            textColor = Color.CYAN
                            textAlignment = TextView.TEXT_ALIGNMENT_CENTER

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
                            inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                        }.lparams(width = matchParent, height = wrapContent) {
                            margin = 15

                        }

                        button("LOGIN") {
                            id = R.id.btnn
                        }.lparams(width = wrapContent, height = wrapContent) {
                            margin = 15
                            gravity = Gravity.CENTER

                        }

                        textView {
                            id = R.id.tv_caa
                            text = "Create Account ?"
                            textSize = 15f //tipedata float
                            textColor = R.color.biru
                            textAlignment = TextView.TEXT_ALIGNMENT_CENTER

                        }.lparams(width = matchParent, height = wrapContent) {
                            margin = 15
                        }


                    }
                }
            }
        }
    }

    private fun handleLogin(username: String, password: String) {
        info { "data username : $username, data password : $password" } //Log i jika ditulis dijavaa
        if (username.equals("test") && password.equals("test123")) {
            toast("Welcome Aboard $username")
            startActivity(intentFor<AfterLogin>("kode" to username ))
        } else {
            alert(title = "Warning", message = "Password atau Username salah") {
                positiveButton(buttonText = "OK") {
                }
                isCancelable = false
            }.show()
        }
    }
}
