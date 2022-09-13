package dev.JoanMuthoni.workoutlog.models

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    var email: String,
    var password: String
)
