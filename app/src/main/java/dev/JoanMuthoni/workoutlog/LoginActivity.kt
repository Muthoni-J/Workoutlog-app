package dev.JoanMuthoni.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var tvSingUp: TextView
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tvSingUp = findViewById(R.id.tvSignUp)
        etEmail = findViewById(R.id.etEmail2)
        etPassword = findViewById(R.id.etPassword2)
        tilEmail = findViewById(R.id.tilEmail2)
        tilPassword = findViewById(R.id.tilPassword2)
        btnLogin = findViewById(R.id.btnLogin)




        tvSingUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }

        btnLogin.setOnClickListener {
            validate()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    fun validate() {
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()


        if (email.isBlank()){
            tilEmail.error = "@string/errorEmail"
        }

        if (password.isBlank()){
            tilPassword.error = "@string/errorPassword"
        }


    }

}