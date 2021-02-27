package com.supplements.posrockettask.room_database

import android.app.Application
import android.content.Context
import androidx.room.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.koin.dsl.module
import javax.inject.Singleton


val roomDatabaseModules = module {
    single { createRoomInstance(get()) }
    single { createCustomerDao(get()) }

}


fun createRoomInstance(application: Application): CustomerDB {
    return Room.databaseBuilder(application, CustomerDB::class.java, "customers")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
}

fun createCustomerDao(customerDB: CustomerDB): CustomerDAO {
    return customerDB.customerDAO()
}



