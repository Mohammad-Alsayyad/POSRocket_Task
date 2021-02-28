package com.supplements.posrockettask.room_database

import android.app.Application
import android.content.Context
import androidx.room.*

import org.koin.dsl.module


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



