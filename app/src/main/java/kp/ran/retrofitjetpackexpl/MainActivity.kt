package kp.ran.retrofitjetpackexpl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kp.ran.retrofitjetpackexpl.ui.theme.RetrofitJetpackExplTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val mainViewModel by viewModels<MainViewModel>()
            mainViewModel.getMovieList()

            Text(text = ""+ mainViewModel.result.data?.get(0)?.first_name)

        }
    }
}

