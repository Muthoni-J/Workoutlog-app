package dev.JoanMuthoni.workoutlog

import dev.JoanMuthoni.workoutlog.models.LoginRequest
import dev.JoanMuthoni.workoutlog.models.RegisterRequest
import dev.JoanMuthoni.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST 

interface ApiInterface {
        @POST("/register")
        suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
        @POST("/login")
        suspend fun loginUser(@Body loginRequest: LoginRequest)
}
