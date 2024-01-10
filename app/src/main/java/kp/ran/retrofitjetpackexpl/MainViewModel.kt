package kp.ran.retrofitjetpackexpl

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var errorMessage: String by mutableStateOf("")

    var result: UserDetails by mutableStateOf(UserDetails())
    
    fun getMovieList() {
        viewModelScope.launch {

            val apiService = AbcAPIServc.getInstance()
            try {
                 result= apiService.getMovies()
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }
}