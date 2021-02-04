package com.supplements.posrockettask.room_database

import android.app.Application
import androidx.room.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
public class DataBaseModule {


    companion object {
        @Provides
        @Singleton
        fun provideDB(application: Application): CustomerDB {
            return Room.databaseBuilder(application, CustomerDB::class.java, "customers")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }


        @Provides
        @Singleton
        fun provideDAO(customerDB: CustomerDB): CustomerDAO {
            return customerDB.customerDAO()
        }
    }


}