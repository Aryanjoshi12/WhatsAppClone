package com.parul.whatsappclone.presentation.userregistration

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parul.whatsappclone.R

@Preview(showSystemUi = true)
@Composable
fun UserRegistration(
    onRegistrationSuccess: () -> Unit = {} // 👈 Callback for navigation
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("India") }
    var countryCode by remember { mutableStateOf("+91") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Enter your number",
            fontSize = 20.sp,
            color = colorResource(R.color.dark_green),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text(text = "WhatsApp will need to verify your phone number.")
            Spacer(modifier = Modifier.width(4.dp))

        }
        Text(text = "What's", color = colorResource(R.color.light_green))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = " my number", color = colorResource(R.color.light_green))

        Spacer(modifier = Modifier.height(16.dp))

        // Country selection row
        TextButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = selectedCountry,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    tint = Color.Black
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 66.dp), thickness = 2.dp
            ,color = colorResource(id = R.color.light_green)
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            listOf("Lasada","Paloda","MotaGav","Karji","Other").forEach{country ->
                DropdownMenuItem(text = { Text(text = country) }, onClick = {
                    selectedCountry = country
                    expanded = false
                })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Phone number input row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = countryCode,
                onValueChange = { countryCode = it },
                modifier = Modifier.width(100.dp),
                singleLine = true,
                label = { Text("Code") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                modifier = Modifier.weight(1f),
                singleLine = true,
                label = { Text("Phone number") }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Next button
        Button(
            onClick = {
                if (phoneNumber.isNotEmpty()) {
                    onRegistrationSuccess() // 👈 Navigate when registration is done
                }
            },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.dark_green),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Next", fontSize = 18.sp, color = Color.White)
        }

    }
}
