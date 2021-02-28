package com.supplements.posrockettask.room_database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.supplements.posrockettask.api.business.customers.model.CustomersData
import io.reactivex.rxjava3.core.Completable


@Dao
interface CustomerDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllCustomers(customersData: MutableList<CustomersData>)

    @Query("SELECT * FROM data")
    suspend fun getAllCustomers() :MutableList<CustomersData>
}