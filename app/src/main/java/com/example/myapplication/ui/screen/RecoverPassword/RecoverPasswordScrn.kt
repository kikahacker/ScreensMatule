package com.example.myapplication.ui.screen.RecoverPassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myapplication.Otp
import com.example.myapplication.R
import com.example.myapplication.SignIn
import com.example.myapplication.ui.screen.component.AuthButton
import com.example.myapplication.ui.screen.component.AuthTextField
import com.example.myapplication.ui.screen.component.MinimalDialog
import com.example.myapplication.ui.screen.component.TitleWithSubtitleText


@Composable
fun RecoverPasswordScrn(navController: NavHostController){
    val recoverPasswordViewModel: RecoverPasswordViewModel = viewModel()
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            )
            {
                IconButton(onClick = {navController.navigate(route = SignIn)}) {
                    Icon(painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null)
                }
            }
        },
    )
    {
        paddingValues ->
        RecoverPasswordContent(paddingValues, recoverPasswordViewModel,navController)
    }
}
@Composable
fun RecoverPasswordContent(
    paddingValues: PaddingValues,
    recoverPasswordViewModel: RecoverPasswordViewModel,
    navController: NavHostController
){
    val openAlertDialog = remember { mutableStateOf(false) }
    val recoverPasswordState = recoverPasswordViewModel.recoverPasswordState
    Column(
        modifier = Modifier.padding(top = 100.dp)
    )
    {
        TitleWithSubtitleText(
            title = stringResource(R.string.miss_pass),
            subTitle = stringResource(R.string.enter_your_email)
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )
        if(openAlertDialog.value){
            MinimalDialog {
                openAlertDialog.value = false
                navController.navigate(Otp)
            }
        }
        AuthTextField(
            value = recoverPasswordState.value.email,
            onChangeValue = {
                recoverPasswordViewModel.setEmail(it)
            },
            isError = recoverPasswordViewModel.emailHasError.value,
            placeholder = {
                Text(text = stringResource(R.string.template_email))
            },
            supportingText = {
                Text(text = stringResource(R.string.incorrect_email))
            },
            label = {
                Text(text = stringResource(R.string.email))
            }
        )
        AuthButton(
            onClick = {openAlertDialog.value = true}
        ) {
            Text(stringResource(R.string.recover))
        }
    }
}





