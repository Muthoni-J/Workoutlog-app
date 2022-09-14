package dev.JoanMuthoni.workoutlog.repository

import dev.JoanMuthoni.workoutlog.ApiClient
import dev.JoanMuthoni.workoutlog.ApiInterface
import dev.JoanMuthoni.workoutlog.models.LoginRequest
import dev.JoanMuthoni.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    var apiClient =  ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest )
    = withContext(Dispatchers.IO) {
            var response = apiClient.loginUser(loginRequest)
            return@withContext response
        }

    suspend fun registerUser(registerRequest:RegisterRequest )
            = withContext(Dispatchers.IO) {
        var response = apiClient.registerUser(registerRequest)
        return@withContext response
    }

}
