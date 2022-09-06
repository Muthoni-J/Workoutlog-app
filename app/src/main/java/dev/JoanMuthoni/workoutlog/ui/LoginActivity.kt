package dev.JoanMuthoni.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.JoanMuthoni.workoutlog.ApiClient
import dev.JoanMuthoni.workoutlog.ApiInterface
import dev.JoanMuthoni.workoutlog.databinding.ActivityLoginBinding
import dev.JoanMuthoni.workoutlog.models.LoginRequest
import dev.JoanMuthoni.workoutlog.models.RegisterRequest
import dev.JoanMuthoni.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences.MODE_PRIVATE)

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
            var loginRequest = RegisterRequest(email, password)
        }
    }

}

fun makeLoginRequest(registerRequest: RegisterRequest) {
    var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    var request = apiClient.registerUser(registerRequest)
    request.enqueue(object : retrofit2.Callback<RegisterResponse> {
        override fun onResponse(
            call: Call<RegisterResponse>,
            response: Response<RegisterResponse>
        ) {
            if (response.isSuccessful) {
                val loginResponse = response.body()
                Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_SHORT).show()

            } else {
                var error = response.errorBody()?.string()
                Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            }
        }

        override fun onFailure(Call: Call<LoginRequest>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }
    })
    fun persistLoginDetails(loginResponse: LoginResponse){
        var editor = sharedPrefs.edit()
        editor.postSting("User_Id",LoginResponse.userid)
        editor.postSting("Access_Tools",LoginResponse.accesstoken)
        editor.postSting("Profile_Id",LoginResponse.profileId)
        editor.apply()
    }
}
