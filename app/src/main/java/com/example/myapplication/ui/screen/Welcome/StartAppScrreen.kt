package com.example.myapplication.ui.screen.Welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MatuleTheme

@Preview
@Composable
fun StartAppScreenPrewiew(){
    MatuleTheme{
        StartAppScreen()
    }
}

@Composable
fun StartAppScreen(){
    val image = painterResource(R.drawable.matule_me)
    val colorlist = listOf(MatuleTheme.colors.colorForGradient1,MatuleTheme.colors.colorForGradient2)
    Box(
        modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(colors = colorlist)),
        contentAlignment = Alignment.Center,

    ) {
        Image(painter = image, contentDescription = null,Modifier.size(214.dp,49.dp))
    }
}