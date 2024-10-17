import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    var currentScreen by remember { mutableStateOf("login") }

    when (currentScreen) {
        "login" -> LoginScreen(onLogin = { currentScreen = "signup" })
        "signup" -> SignUpScreen(onSignUp = { currentScreen = "resetPassword" })
        "resetPassword" -> ResetPasswordScreen(onPasswordReset = { currentScreen = "login" })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppContent()
}
