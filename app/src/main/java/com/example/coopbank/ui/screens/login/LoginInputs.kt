package com.example.coopbank.ui.screens.login
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coopbank.R
import com.example.coopbank.ui.components.EmailTextField
import com.example.coopbank.ui.components.PasswordTextField
import com.example.coopbank.ui.screens.login.state.LoginState
import com.example.coopbank.ui.theme.AppTheme

@Composable
fun LoginInputs(
    loginState: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {

    // Login Inputs Section
    Column(modifier = Modifier.fillMaxSize() .padding(top = 128.dp),verticalArrangement = Arrangement.Center,) {
        Text(

            text = stringResource(id = R.string.login_heading_text),
            color= Color.White
        )
        // Email or Mobile Number
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),

            value = loginState.email,
            onValueChange = onEmailChange,
            label = stringResource(id = R.string.login_email_id),
            isError = loginState.errorState.emailErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.emailErrorState.errorMessageStringResource)
        )


        // Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.login_password_label),
            isError = loginState.errorState.passwordErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.passwordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Done
        )

    }
}
@Composable
fun RegisterInputs(
    loginState: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,

    ) {

    // Login Inputs Section
    Column(modifier = Modifier.fillMaxWidth()) {

        // Email or Mobile Number
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.email,
            onValueChange = onEmailChange,
            label = stringResource(id = R.string.login_email_id),
            isError = loginState.errorState.emailErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.emailErrorState.errorMessageStringResource)
        )


        // Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.login_password_label),
            isError = loginState.errorState.passwordErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.passwordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Done
        )





    }
}