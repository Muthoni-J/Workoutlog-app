package dev.JoanMuthoni.workoutlog

import dev.JoanMuthoni.workoutlog.models.LoginRequest
import dev.JoanMuthoni.workoutlog.models.RegisterRequest
import dev.JoanMuthoni.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
        @POST("/register")
        fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
        @POST("/Login")
        fun loginUser(@Body loginRequest: LoginRequest): Call<LoginRequest>
}
