package dev.JoanMuthoni.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import dev.JoanMuthoni.workoutlog.ApiClient
import dev.JoanMuthoni.workoutlog.ApiInterface
import dev.JoanMuthoni.workoutlog.databinding.ActivitySignupBinding
import dev.JoanMuthoni.workoutlog.models.RegisterRequest
import dev.JoanMuthoni.workoutlog.models.RegisterResponse
import okhttp3.Response
import retrofit2.Call
import java.util.regex.Pattern
import javax.security.auth.callback.Callback

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
        var phonenumber = binding.etPhoneNumber.text.toString()
        var email2 = binding.etEmail2.text.toString()
        var password2 = binding.etPassword2.text.toString()
        var confirmpassword = binding.etConfirmpassword.text.toString()


        var error = false
        if (firstname.isBlank()) {
            error = true
            binding.tilFirstname.error = "Enter your first name"
        }
        if (secondname.isBlank()) {
            error = true
            binding.tilFirstname.error = "Enter your  second name"
        }
        if (phonenumber.isBlank()) {
            error = true
            binding.tilPhoneNumber.error = "Enter your phone number"
        }
        if (email2.isBlank()) {
            error = true
            binding.tilEmail2.error = "Enter your  second name"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email2).matches()) {
            binding.tilEmail2.error = "Enter your  second name"
        }
        if (password2.isBlank()) {
            error = true
            binding.tilPassword2.error = "Enter your  second name"
        }

        if (confirmpassword.isBlank()) {
            error = true
            binding.tilConfirmpassword.error = "Enter your  second name"
        }
        if (confirmpassword != password2) {
            error = true
            binding.tilConfirmpassword.error = "Wrong password"
        }
        if (!error) {
            binding.progressBar.visibility= View.VISIBLE
            val RegisterRequest = RegisterRequest(firstname, secondname, phonenumber, email2, password2)
            makeRegisterationRequest(RegisterRequest)
        }
    }



fun makeRegisterationRequest(registerRequest: RegisterRequest){
    var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    var request=apiClient.registerUser(registerRequest)
    request.enqueue(object :retrofit2.Callback<RegisterResponse>{
        override fun onResponse(
            call: Call<RegisterResponse>,
            response: retrofit2.Response<RegisterResponse>

        ) {
            binding.progressBar.visibility=View.GONE
            if (response.isSuccessful){
                var message=response.body()?.message
                Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()

            }else{
                val error=response.errorBody()?.string()
                Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()

            }

        }

        override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

        }


    }  )  }
}




