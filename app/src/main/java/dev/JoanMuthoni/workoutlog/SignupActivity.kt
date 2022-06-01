package dev.JoanMuthoni.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tvSingUp:TextView
    lateinit var etFirstname: TextInputEditText
    lateinit var etSecondname: TextInputEditText
    lateinit var tilFirstname: TextInputLayout
    lateinit var tilSecondname: TextInputLayout
    lateinit var etEmail2: TextInputEditText
    lateinit var etPassword2: TextInputEditText
    lateinit var etConfirmpassword:TextInputEditText
    lateinit var tilEmail2: TextInputLayout
    lateinit var tilPassword2: TextInputLayout
    lateinit var tilConfirmpassword: TextInputLayout
    lateinit var btnSignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        etFirstname = findViewById(R.id.etFirstName)
        etSecondname = findViewById(R.id.etSecondname)
        tilFirstname = findViewById(R.id.tilFirstname)
        tilSecondname = findViewById(R.id.tilSecondname)
        etEmail2 = findViewById(R.id.etEmail2)
        etPassword2 = findViewById(R.id.etPassword2)
        etConfirmpassword = findViewById(R.id.etConfirmpassword)
        tilEmail2 = findViewById(R.id.tilEmail2)
        tilPassword2 = findViewById(R.id.tilPassword2)
        tilConfirmpassword = findViewById(R.id.tilConfirmpassword)
        btnSignup = findViewById(R.id.btnSignup)
        tvSingUp = findViewById(R.id.tvSignUp)
        tvSingUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            validate()
        }

    }

    fun validate(){
        var firstname = etFirstname.text.toString()
        var secondname = etSecondname.text.toString()
        var email2 = etEmail2.text.toString()
        var password2 = etPassword2.text.toString()
        var confirmpassword = etConfirmpassword.text.toString()





        if (firstname.isBlank()){
            tilFirstname.error = "Enter your first name"
        }
        if (secondname.isBlank()){
            tilFirstname.error = "Enter your  second name"
        }
        if (email2.isBlank()){
             tilEmail2.error = "Enter your  second name"
         }

        if (password2.isBlank()){
            tilPassword2.error = "Enter your  second name"
        }

        if (confirmpassword.isBlank()){
            tilConfirmpassword.error = "Enter your  second name"
        }


    }
}

