package com.example.myapplication.ui.screen.SignUp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.RecoverPassword
import com.example.myapplication.SignIn
import com.example.myapplication.ui.data.domain.usecase.AuthUseCase
import com.example.myapplication.ui.data.remote.RetrofitClient
import com.example.myapplication.ui.data.remote.User
import com.example.myapplication.ui.screen.RecoverPassword.RecoverPasswordScrn
import com.example.myapplication.ui.screen.SignIn.SignInScrn
import com.example.myapplication.ui.screen.component.AuthButton
import com.example.myapplication.ui.screen.component.AuthTextField
import com.example.myapplication.ui.screen.component.TitleWithSubtitleText
import com.example.myapplication.ui.theme.MatuleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScrn(onNavigationToHome: () -> Unit, navController: NavHostController) {
    val snackBarHostState = remember { SnackbarHostState() }
    val signUpViewModel:SignUpViewModel = koinViewModel()

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                IconButton(onClick = {navController.navigate(SignIn)}) {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null
                    )
                }
            }
        },
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Button(
                    onClick = { navController.navigate(SignIn) },

                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    elevation = null

                ) {
                    Text(
                        text = stringResource(R.string.sign_in),
                        style = MatuleTheme.typography.subTitleRegular16.copy(color = MatuleTheme.colors.text)
                    ) }
            }
        }
    )
    {
        paddingValues ->
        SignUpContent(paddingValues, signUpViewModel)

        val registrationScreenState = signUpViewModel.signUpState
        LaunchedEffect(registrationScreenState.value.isSignUp) {
            if(registrationScreenState.value.isSignUp) {
                onNavigationToHome()
            }
        }

        LaunchedEffect(registrationScreenState.value.errorMessage) {
            registrationScreenState.value.errorMessage?.let {
                snackBarHostState.showSnackbar(it)
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SignUpContent(paddingValues: PaddingValues, signUpViewModel: SignUpViewModel) {
    val signUpState = signUpViewModel.signUpState
    Column(
        modifier = Modifier.padding(paddingValues = paddingValues),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TitleWithSubtitleText(
            title = stringResource(R.string.registration),
            subTitle = stringResource(R.string.sign_in_subtitle)
        )
        Spacer(modifier = Modifier.height(35.dp))

        AuthTextField(
            value = signUpState.value.name,
            onChangeValue = { signUpViewModel.setName(it) },
            isError = false,
            placeholder = { Text(text = stringResource(R.string.enter_name)) },
            supportingText = { Text(text = stringResource(R.string.incorrect_name)) },
            label = { Text(text = stringResource(R.string.name)) }
        )

        AuthTextField(
            value = signUpState.value.email,
            onChangeValue = { signUpViewModel.setEmail(it) },
            isError = signUpViewModel.emailHasError.value,
            placeholder = { Text(text = stringResource(R.string.template_email)) },
            supportingText = { Text(text = stringResource(R.string.enter_email)) },
            label = { Text(text = stringResource(R.string.email)) }
        )

        AuthTextField(
            value = signUpState.value.password,
            onChangeValue = { signUpViewModel.setPassword(it) },
            isError = false,
            placeholder = { Text(text = stringResource(R.string.password_template)) },
            supportingText = { Text(text = stringResource(R.string.incorrect_password)) },
            label = { Text(text = stringResource(R.string.password)) }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.policy_check),
                contentDescription = null,
                modifier = Modifier.height(18.dp)
            )
            Text(
                text = stringResource(R.string.privacy_policy),
                modifier = Modifier.padding(start = 20.dp),
                style = MatuleTheme.typography.bodyRegular12.copy(
                    color = MatuleTheme.colors.subTextDark,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
        val coroutine = rememberCoroutineScope{Dispatchers.IO}
        AuthButton(onClick = {
            val user = User(userName = signUpState.value.name, email = signUpState.value.email, password = signUpState.value.password)
            signUpViewModel.signUp()

            coroutine.launch {
                RetrofitClient.retrofit.registration(user)
            }
        }) {
            Text(stringResource(R.string.sign_up))
            if(signUpState.value.isLoading)CircularProgressIndicator(color = Color.White)
        }
    }
}