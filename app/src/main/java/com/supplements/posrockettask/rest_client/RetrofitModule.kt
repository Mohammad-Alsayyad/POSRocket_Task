package com.supplements.posrockettask.rest_client

import com.supplements.posrockettask.general.AppConstants.BASE_URL
import com.supplements.posrockettask.network.APIEndpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RetrofitModule {

    companion object {
        @Provides
        @Singleton
        fun endpoint(): APIEndpoint {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(APIEndpoint::class.java)
        }

    }

}



