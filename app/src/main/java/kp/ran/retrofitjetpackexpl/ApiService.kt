package kp.ran.retrofitjetpackexpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface David {

   /* @GET("api/users")
    suspend fun getMovies() : WeatherDetails*/

    @GET("weather/")
    suspend fun getWeatherByCity(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ) : WeatherDetails

    companion object {
        var api: David? = null
        fun getInstance() : David {
            api = Retrofit.Builder()
                   // .baseUrl("https://reqres.in/")
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                .build().create(David::class.java)
            return api!!
        }
    }
}