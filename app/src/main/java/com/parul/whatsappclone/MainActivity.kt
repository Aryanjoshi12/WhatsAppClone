package com.parul.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.parul.whatsappclone.presentation.homescreen.HomeScreen
import com.parul.whatsappclone.presentation.splashscreen.SplashScreen
import com.parul.whatsappclone.presentation.userregistration.UserRegistration
import com.parul.whatsappclone.presentation.welcomescreen.WelcomeScreen
import com.parul.whatsappclone.ui.theme.WhatsAppCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppCloneTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash" // 👈 First screen
    ) {
        composable("splash") {
            SplashScreen(onSplashFinished = {
                navController.navigate("welcome") {
                    popUpTo("splash") { inclusive = true } // clear splash from backstack
                }
            })
        }

        composable("welcome") {
            WelcomeScreen(
                onAgreeClicked = {
                    navController.navigate("register") {
                        popUpTo("welcome") { inclusive = true }
                    }
                }
            )
        }
        composable("register") {
            UserRegistration(
                onRegistrationSuccess = { // 👈 Add callback
                    navController.navigate("home") {
                        popUpTo("register") { inclusive = true } // remove registration from backstack
                    }
                }
            )
        }
        composable("home") {
            HomeScreen()
        }
    }

}
