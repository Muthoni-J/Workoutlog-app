package dev.JoanMuthoni.workoutlog

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.JoanMuthoni.workoutlog.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    lateinit var binding:ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            validate()

        }

    }

    fun validate() {
        var firstname = binding.etFirstName.text.toString()
        var secondname = binding.etSecondname.text.toString()
        var email2 = binding.etEmail2.text.toString()
        var password2 = binding.etPassword2.text.toString()
        var confirmpassword = binding.etConfirmpassword.text.toString()





        if (firstname.isBlank()) {
            binding.tilFirstname.error = "Enter your first name"
        }
        if (secondname.isBlank()) {
            binding.tilFirstname.error = "Enter your  second name"
        }
        if (email2.isBlank()) {
            binding.tilEmail2.error = "Enter your  second name"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email2).matches()) {
            binding.tilEmail2.error = "Enter your  second name"
        }
        if (password2.isBlank()) {
            binding.tilPassword2.error = "Enter your  second name"
        }

        if (confirmpassword.isBlank()) {
            binding.tilConfirmpassword.error = "Enter your  second name"
        }
        if (confirmpassword != password2) {
            binding.tilConfirmpassword.error = "Wrong password"
        }

    }
}

