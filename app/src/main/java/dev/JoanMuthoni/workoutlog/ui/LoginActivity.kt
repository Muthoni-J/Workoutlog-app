package dev.JoanMuthoni.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.JoanMuthoni.workoutlog.databinding.ActivityLoginBinding
import dev.JoanMuthoni.workoutlog.models.LoginRequest
import dev.JoanMuthoni.workoutlog.models.LoginResponse
import dev.JoanMuthoni.workoutlog.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)
            sharedPrefs = getSharedPreferences("WORKOUTLOG", MODE_PRIVATE)

            binding.tvSignUp.setOnClickListener {
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }

            binding.btnLogin.setOnClickListener {
                validate()
            }
        }

        override fun onResume() {
            super.onResume()
            userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse ->
                persistLoginDetails(loginResponse!!)
                Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext, HomeActivity::class.java))
                finish()
            })

            userViewModel.loginErrorLiveData.observe(this, Observer { error ->
                Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            })
        }

        fun validate() {
            var email = binding.etEmail2.text.toString()
            var password = binding.etPassword2.text.toString()
            var error = false
            if (email.isBlank()) {
                error = true
                binding.tilEmail2.error = "@string/errorEmail"
            }

            if (password.isBlank()) {
                error = true
                binding.tilPassword2.error = "Password is required"
            }
            if (!error) {
                var loginRequest = LoginRequest(email, password)
                userViewModel.loginUser(loginRequest)
            }
        }

    fun persistLoginDetails(loginResponse: LoginResponse) {
        var editor = sharedPrefs.edit()
        editor.putString("User_Id", loginResponse.userId)
        editor.putString("Access_Tools", loginResponse.accessToken)
        editor.putString("Profile_Id", loginResponse.profileId)
        editor.apply()
    }
}