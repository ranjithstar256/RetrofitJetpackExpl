package kp.ran.retrofitjetpackexpl


 import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AbcAPIServc {
    @GET("api/users")
    suspend fun getMovies() : UserDetails

    companion object {
        var apiService: AbcAPIServc? = null
        fun getInstance() : AbcAPIServc {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://reqres.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                .build().create(AbcAPIServc::class.java)
            }
            return apiService!!
        }
    }
}