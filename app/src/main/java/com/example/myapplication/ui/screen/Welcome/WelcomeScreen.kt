package com.example.myapplication.ui.screen.Welcome

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.common.CommonButton
import com.example.myapplication.ui.theme.MatuleTheme
import com.example.myapplication.ui.theme.matuleFontFamily

@Preview
@Composable
fun WelcomeScreenPrewiew(){
    MatuleTheme{
        WelcomeScreen()
    }
}

@Composable
fun WelcomeScreen(){
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null
                    )
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                .padding(top = 35.dp)
                .fillMaxWidth()
                .height(40.dp)
            ) {
                Button(onClick = {}, colors = ButtonColors(containerColor = MatuleTheme.colors.block, contentColor = Color.Black, disabledContainerColor = Color.Black, disabledContentColor = Color.Black)
                ) { }
            }
        }

    ){
        paddingValues ->  WelcomeScreenContent(paddingValues)
    }
}
fun  WelcomeScreenContent(paddingValues: PaddingValues){}