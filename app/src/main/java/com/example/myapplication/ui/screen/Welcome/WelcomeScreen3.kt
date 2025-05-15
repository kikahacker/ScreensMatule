package com.example.myapplication.ui.screen.Welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MatuleTheme

@Preview
@Composable
fun WelcomeScreen3Prewiew(){
    MatuleTheme{
        WelcomeScreen3()
    }
}

@Composable
fun WelcomeScreen3(){
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(bottom = 270.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Row {
                    Text(text = "У Вас Есть Сила, Чтобы",
                        modifier = Modifier
                            .height(89.dp)
                            .width(315.dp),
                        textAlign = TextAlign.Center,
                        style = MatuleTheme.typography.headingBold30.copy(color = MatuleTheme.colors.block))
                }

            }
            Row(
                modifier = Modifier
                    .padding(top = 89.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Row {
                    Text(text = "В вашей комнате много красивых  ипривлекательных растений",
                        modifier = Modifier
                            .height(48.dp)
                            .width(322.dp),
                        textAlign = TextAlign.Center,
                        style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.block))
                }
            }

        })
    {
            paddingValues ->  WelcomeScreen3Content(paddingValues)
    }
}
@Composable
fun WelcomeScreen3Content(paddingValues: PaddingValues){
    val colorlist = listOf(MatuleTheme.colors.colorForGradient1, MatuleTheme.colors.colorForGradient2)
    Column(
        Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = colorlist)),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.welcome_screen3_boot),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 251.dp)
                .width(465.dp)
                .height(465.dp)
        )


    }

    Row(modifier = Modifier.padding(top = 766.dp)){
        Button(onClick = {},
            colors = ButtonColors(containerColor = MatuleTheme.colors.block,
                contentColor = Color.Black,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 36.dp)
                .width(335.dp)
                .height(50.dp),
            shape = RoundedCornerShape(13.dp)
        ) {
            Text(text = "Далее", style = MatuleTheme.typography.bodyRegular14)

        }
    }
}