package com.supplements.posrockettask

import android.app.Application
import com.supplements.posrockettask.api.business.customers.customersRepository
import com.supplements.posrockettask.retrofit.networkModule
import com.supplements.posrockettask.room_database.roomDatabaseModules
import com.supplements.posrockettask.ui.activities.home_page.homeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


val moduleList = listOf(
        networkModule ,
        customersRepository,
        homeViewModel,
        roomDatabaseModules
)
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(moduleList)
        }
    }
}