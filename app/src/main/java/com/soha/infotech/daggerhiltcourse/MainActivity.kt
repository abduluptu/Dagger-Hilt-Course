package com.soha.infotech.daggerhiltcourse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.soha.infotech.daggerhiltcourse.ui.theme.DaggerHiltCourseTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * Note: If we use Fragment, then we need to annotate with @AndroidEntryPoint and write same code
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // Field injection
    @Inject
    // @Named("firebase")
    @FirebaseQualifier
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaggerHiltCourseTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                    userRepository.saveUser("test@gmail.com", "111111")
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerHiltCourseTheme {
        Greeting("Android")
    }
}