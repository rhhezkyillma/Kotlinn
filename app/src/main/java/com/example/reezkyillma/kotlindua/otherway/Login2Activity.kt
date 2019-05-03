package com.example.reezkyillma.kotlindua.otherway

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.reezkyillma.kotlindua.R
import org.jetbrains.anko.*

class Login2Activity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)

        var imageView: ImageView = findViewById(R.id.logo)
        var btn: Button = findViewById(R.id.btnn)
        var uname: EditText = findViewById(R.id.et_usernamee)
        var password: TextView = findViewById(R.id.et_passwordd)
        var forgot: TextView = findViewById(R.id.tv_forgot)
        var member: TextView = findViewById(R.id.tv_member)
        btn.setOnClickListener {


            val username = uname.text.toString().trim()
            val password = password.text.toString().trim()
            handleLogin(username, password)
        }

        member.setOnClickListener {
            startActivity(intentFor<Regis2Activity>())
        }
    }

    //membuat class yang akan mendesign layoutt

    class LoginView : AnkoComponent<Login2Activity> {
        override fun createView(ui: AnkoContext<Login2Activity>) = with(ui) {

            verticalLayout {


                lparams(width = matchParent, height = matchParent) {
                    backgroundColor = Color.rgb(11, 120, 155)
                }
                imageView {
                    id = R.id.logo
                    imageResource = R.drawable.firebase


                }.lparams(width = 150, height = 300) {
                    gravity = Gravity.CENTER


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

                button("LOGIN") {
                    id = R.id.btnn
                    textColor = Color.BLACK
                    backgroundColor = Color.YELLOW
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    gravity = Gravity.CENTER

                }

                textView {
                    id = R.id.tv_forgot
                    text = "Forgot your password ?"
                    textSize = 15f //tipedata float
                    textColor = Color.YELLOW
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER

                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                }

                textView {
                    id = R.id.tv_member
                    text = "Not a member ? Get registered in Firebase now !"
                    textSize = 15f //tipedata float
                    textColor = Color.WHITE
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER

                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 100
                }


            }

        }
    }


    private fun handleLogin(username: String, password: String) {
        info { "data username : $username, data password : $password" } //Log i jika ditulis dijavaa
        if (username.equals("test") && password.equals("test123")) {
            toast("Welcome Aboard $username")
        } else {
            alert(title = "Warning", message = "Password atau Username salah") {
                positiveButton(buttonText = "OK") {
                }
                isCancelable = false
            }.show()
        }
    }
}