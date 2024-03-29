package com.example.coopbank.ui.screens.login.state

import com.example.coopbank.ui.components.ErrorState


/**
 * Login State holding ui input values
 */
data class LoginState(
    val username: String = "",
    val password: String = "",
    val errorState: LoginErrorState = LoginErrorState(),
    val isLoginSuccessful: Boolean = false
)

/**
 * Error state in login holding respective
 * text field validation errors
 */
data class LoginErrorState(
    val usernameErrorState: ErrorState = ErrorState(),
    val passwordErrorState: ErrorState = ErrorState()
)

