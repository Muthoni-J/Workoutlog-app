package dev.JoanMuthoni.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.JoanMuthoni.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
       setContentView(binding.root)



        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }

        binding.btnLogin.setOnClickListener {
            validate()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    fun validate() {
        var email = binding.etEmail2.text.toString()
        var password = binding.etPassword2.text.toString()


        if (email.isBlank()){
            binding.tilEmail2.error = "@string/errorEmail"
        }

        if (password.isBlank()){
            binding.tilPassword2.error = "@string/errorPassword"
        }


    }

}