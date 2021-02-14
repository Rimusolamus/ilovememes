package cz.rimu.ilovememes.rest

import cz.rimu.ilovememes.rest.model.Hot
import retrofit2.http.GET

interface Api {
    @GET("hot.json")
    suspend fun getAllFunny(): Hot
}