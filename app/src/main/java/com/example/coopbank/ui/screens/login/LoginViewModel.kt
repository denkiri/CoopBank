package com.example.coopbank.ui.screens.login
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.coopbank.ui.components.ErrorState
import com.example.coopbank.repository.LoginRepository
import com.example.coopbank.ui.screens.login.state.LoginErrorState
import com.example.coopbank.ui.screens.login.state.LoginState
import com.example.loginapp.screens.login.state.LoginUiEvent
import com.example.coopbank.ui.screens.login.state.emailEmptyErrorState
import com.example.coopbank.ui.screens.login.state.passwordEmptyErrorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel(){
    var loginState = mutableStateOf(LoginState())
    fun resetStates() {
        // Reset or clear loginState here
       loginState.value = LoginState() // Reset to initial value or null

    }

    private val _isLoading = MutableStateFlow(true) // Initialize as true to start loading
    val isLoading: StateFlow<Boolean> = _isLoading

    fun onUiEvent(loginUiEvent: LoginUiEvent) {
        when (loginUiEvent) {

            // Email/Mobile changed
            is LoginUiEvent.EmailChanged -> {
                loginState.value = loginState.value.copy(
                    username = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        usernameErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailEmptyErrorState
                    )
                )
            }

            // Password changed
            is LoginUiEvent.PasswordChanged -> {
                loginState.value = loginState.value.copy(
                    password = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        passwordErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            passwordEmptyErrorState
                    )
                )
            }

            // Submit Login
            is LoginUiEvent.Submit -> {
                val inputsValidated = validateInputs()
                if (inputsValidated) {
                    isLoading
                    // TODO Trigger login in authentication flow
                    loginState.value = loginState.value.copy(isLoginSuccessful = true)


                }
            }
        }
    }

    /**
     * Function to validate inputs
     * Ideally it should be on domain layer (usecase)
     * @return true -> inputs are valid
     * @return false -> inputs are invalid
     */
    private fun validateInputs(): Boolean {
        val emailOrMobileString = loginState.value.username.trim()
        val passwordString = loginState.value.password
        return when {

            // Email/Mobile empty
            emailOrMobileString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        usernameErrorState = emailEmptyErrorState
                    )
                )
                false
            }

            //Password Empty
            passwordString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        passwordErrorState = passwordEmptyErrorState
                    )
                )
                false
            }
            // No errors
            else -> {
                // Set default error state
                loginState.value = loginState.value.copy(username = emailOrMobileString)

                loginState.value = loginState.value.copy(errorState = LoginErrorState())
                true
            }
        }
    }


}