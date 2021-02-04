package com.supplements.posrockettask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.supplements.posrockettask.model.CustomersData
import com.supplements.posrockettask.network.APIEndpoint
import com.supplements.posrockettask.room_database.CustomerDAO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(var endpoint: APIEndpoint, var customerDAO: CustomerDAO) {

    fun getAllCustomers(isConnected: Boolean): LiveData<MutableList<CustomersData>> {
        return if (isConnected) {
            getCustomersFromApi()
        } else {
            getCustomersFromRoom()
        }
    }

    private fun getCustomersFromApi(): LiveData<MutableList<CustomersData>> {

        val customerList: MutableLiveData<MutableList<CustomersData>> =
            MutableLiveData<MutableList<CustomersData>>()

        endpoint.getAllCustomers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                if (customerDAO.getDataCount() != it.data.size) {
                    cachingData(it.data)
                }
                customerList.value = it.data

            }
            ) { error ->
                error.printStackTrace()
            }

        return customerList
    }

    private fun cachingData(data: MutableList<CustomersData>) {

        customerDAO.insertAllCustomers(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableCompletableObserver() {
                override fun onStart() {
                    Log.d("ConversationActivity", "onStart")
                }

                override fun onComplete() {
                    Log.d("ConversationActivity", "onComplete")
                }

                override fun onError(e: Throwable) {
                    Log.d("ConversationActivity", "onError: $e.message")
                }
            })

    }

    private fun getCustomersFromRoom(): LiveData<MutableList<CustomersData>> {

        return  customerDAO.getAllCustomers()
    }

}