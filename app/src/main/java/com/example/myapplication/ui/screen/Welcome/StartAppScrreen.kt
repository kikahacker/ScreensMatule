package com.example.myapplication.ui.screen.Welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.data.domain.usecase.AuthUseCase
import com.example.myapplication.ui.local.DataStoreOnBoarding
import com.example.myapplication.ui.theme.MatuleTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.firstOrNull


@Composable
fun StartAppScreen(
    authUseCase: AuthUseCase,
    dataStore: DataStoreOnBoarding,
    onNavigateToSignIn: () -> Unit,
    onNavigateToSlides: () -> Unit,
    onNavigateToHome: () -> Unit
){
    val token by authUseCase.token.collectAsState(initial = "")
    val image = painterResource(R.drawable.matule_me)
    val colorlist = listOf(MatuleTheme.colors.colorForGradient1,MatuleTheme.colors.colorForGradient2)
    Column(
        modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(colors = colorlist)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(painter = image, contentDescription = null,Modifier.size(214.dp,49.dp))
    }
    LaunchedEffect(Unit) { delay(3000)

    val completed = dataStore.onBoardingCompleted.firstOrNull() ?: false

    if (completed) {
        if (token.isNotEmpty()) {
            onNavigateToHome()
        } else {
            onNavigateToSignIn()
        }
    } else {
        onNavigateToSlides()
    }}
}


