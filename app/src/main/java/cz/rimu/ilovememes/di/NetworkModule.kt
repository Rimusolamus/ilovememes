package cz.rimu.ilovememes.di

import cz.rimu.ilovememes.BuildConfig.API_URL
import cz.rimu.ilovememes.rest.Api
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideRestApi(get()) }
    single { provideRetrofit() }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideRestApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)