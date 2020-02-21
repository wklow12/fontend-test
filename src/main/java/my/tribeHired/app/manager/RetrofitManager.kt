package my.tribeHired.app.manager

import com.facebook.stetho.okhttp3.StethoInterceptor
import my.tribeHired.app.AppApi
import my.tribeHired.app.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitManager {

    val appApi : AppApi = Retrofit.Builder()
        .baseUrl(BuildConfig.server_endpoint)
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideHttpClient())
        .build().create(AppApi::class.java)

    private fun provideHttpClient(): OkHttpClient {

        val builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            builder.addNetworkInterceptor(StethoInterceptor())
        }

        return builder.build()
    }
}