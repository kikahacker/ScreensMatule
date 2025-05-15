package com.example.myapplication.ui.screen.Welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
fun WelcomeScreen1Prewiew(){
    MatuleTheme{
        WelcomeScreen1()
    }
}

@Composable
fun WelcomeScreen1(){
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 121.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Row {
                    Text(text = stringResource(R.string.Welcome),
                        modifier = Modifier
                            .height(70.dp)
                            .width(267.dp),
                        textAlign = TextAlign.Center,
                        style = MatuleTheme.typography.headingExtraBold32.copy(color = MatuleTheme.colors.block))
                }
            }


        },
        bottomBar = {
            Row(

            ) {
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
                    Text(text = "Начать", style = MatuleTheme.typography.bodyRegular14)

                }
            }
        }

    ){
            paddingValues ->  WelcomeScreen1Content(paddingValues)
    }
}
@Composable
fun  WelcomeScreen1Content(paddingValues: PaddingValues){
    val colorlist = listOf(MatuleTheme.colors.colorForGradient1,MatuleTheme.colors.colorForGradient2)
    Box(
        modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(colors = colorlist)),

        ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 219.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.zagagylia),
                contentDescription = null,
                modifier = Modifier
                    .height(18.dp)
                    .width(134.dp),
            )
        }
        Image(
            painter = painterResource(R.drawable.highlight_05),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 106.dp, start = 59.dp, bottom = 676.dp, end = 289.dp)
                .height(27.dp)
                .width(30.dp),
        )

    }
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.zagagyliami),
            contentDescription = null,
            modifier = Modifier
                .height(524.dp)
                .width(315.dp),
        )

    }

    Image(
        painter = painterResource(R.drawable.boot),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 152.dp)
            .height(420.dp)
            .width(560.dp),
    )
}