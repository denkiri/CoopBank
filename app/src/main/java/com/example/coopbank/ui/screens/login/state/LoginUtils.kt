package com.example.coopbank.ui.screens.login.state
import com.example.coopbank.R
import com.example.coopbank.ui.components.ErrorState
val emailEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)
val loginErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_user_not_found
)