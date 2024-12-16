package kp.ran.retrofitjetpackexpl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var result: WeatherDetails by remember {    mutableStateOf(WeatherDetails())   }

            runBlocking {
                result = David.getInstance().getWeatherByCity("chennai",
                    "a6ea090d1f474d6abdee5db6552ff501"
                    )
            }
            Text(
                text = ""+ result.weather?.get(0)?.description.toString(),fontSize = 32.sp
            )
        }
    }
}
// Retrofit API call