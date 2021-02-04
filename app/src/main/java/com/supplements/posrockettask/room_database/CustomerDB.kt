package com.supplements.posrockettask.room_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.supplements.posrockettask.model.CustomersData
import com.supplements.posrockettask.model.PhoneNumbers
import com.supplements.posrockettask.model.addresses.*
import com.supplements.posrockettask.model.tags.Discounts
import com.supplements.posrockettask.model.tags.Tags
import com.supplements.posrockettask.room_database.CustomerDAO

@Database(
    entities = [CustomersData::class, Addresses::class,
        Area::class, Avenue::class, Block::class, City::class, Position::class, Tags::class, Discounts::class , PhoneNumbers::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverter::class)
public abstract class CustomerDB : RoomDatabase() {

    abstract fun customerDAO(): CustomerDAO

}