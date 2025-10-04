package com.parul.whatsappclone.presentation.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parul.whatsappclone.R

@Composable
fun WelcomeScreen(
    onAgreeClicked: () -> Unit // 👈 added callback
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, // explicit for readability
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.whatsapp_sticker),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
        Text(text = "Welcome to WhatsApp", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text(text = "Read our", color = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Privacy Policy", color = colorResource(R.color.light_green))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Tap 'Agree' and accept", color = Color.Gray)
        }
        Row {
            Text(text = "accept the", color = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Terms of Service", color = colorResource(R.color.light_green))
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onAgreeClicked() }, // 👈 trigger navigation
            modifier = Modifier.size(280.dp, 43.dp),
            shape = RoundedCornerShape(8.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.dark_green),
                contentColor = Color.White
            )
        ) {
            Text(text = "Agree and continue", fontSize = 18.sp, color = Color.White)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onAgreeClicked = {}) // 👈 preview works
}
