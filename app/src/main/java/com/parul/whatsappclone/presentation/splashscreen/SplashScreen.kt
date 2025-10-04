package com.parul.whatsappclone.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parul.whatsappclone.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit // 👈 callback for navigation
) {
    // Run once when composable enters composition
    LaunchedEffect(Unit) {
        delay(2000) // 2 second splash delay
        onSplashFinished()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.whatsapp_icon),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center)
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "From",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.meta),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = colorResource(R.color.light_green)
                )
                Text(
                    text = "Meta",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(onSplashFinished = {})
}
