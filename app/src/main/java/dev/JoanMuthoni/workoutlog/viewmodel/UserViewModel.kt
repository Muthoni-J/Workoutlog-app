package dev.JoanMuthoni.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.JoanMuthoni.workoutlog.models.LoginRequest
import dev.JoanMuthoni.workoutlog.models.LoginResponse
import dev.JoanMuthoni.workoutlog.models.RegisterRequest
import dev.JoanMuthoni.workoutlog.models.RegisterResponse
import dev.JoanMuthoni.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val  userRepository = UserRepository()
    var  loginResponseLiveData = MutableLiveData<LoginResponse>()
    val  loginErrorLiveData = MutableLiveData<String?>()
    var  registerResponseLiveData =  MutableLiveData<RegisterResponse>()
    val  registerErrorLiveData = MutableLiveData<String?>()

     fun loginUser (loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if(response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }
            else{
                val error = response.errorBody()?.string()
                loginErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
fun  registerUser(registerRequest: RegisterRequest){
    viewModelScope.launch {
        val response = userRepository.registerUser(registerRequest)
        if(response.isSuccessful){
            registerResponseLiveData.postValue(response.body())
        }else{
            var error=response.errorBody()?.string()
            registerErrorLiveData.postValue(error)
        }
    }
}
}