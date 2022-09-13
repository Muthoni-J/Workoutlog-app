package dev.JoanMuthoni.workoutlog.usermodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.JoanMuthoni.workoutlog.models.LoginRequest
import dev.JoanMuthoni.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val  userRepository = UserRepository()
    var  loginResponseLiveData = MutableLiveData<LoginRequest>()
    val  loginErrorLiveData = MutableLiveData<String?>()

     fun loginUser (loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if(response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }
            else{
                loginErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}