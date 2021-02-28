package com.supplements.posrockettask.ui.activities.home_page


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supplements.posrockettask.api.business.customers.CustomersRepository
import com.supplements.posrockettask.api.business.customers.model.CustomersData
import com.supplements.posrockettask.room_database.CustomerDAO
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.lang.Exception

val homeViewModel = module {
    viewModel {
        HomeViewModel(get(), get())
    }
}

class HomeViewModel constructor(var repository: CustomersRepository, var customerDAO: CustomerDAO) :
    ViewModel() {

    val customersList: MutableLiveData<MutableList<CustomersData>> by lazy {
        MutableLiveData<MutableList<CustomersData>>()
    }
    init {
        getAllCustomers()
    }

    fun getAllCustomers() {

        GlobalScope.launch(Dispatchers.IO) {

            /*val api: Job = launch { getCustomersFromNetwork() }
            api.join()*/

            launch {
                customersList.postValue(getCustomersFromDatabase())
            }

        }
    }

    private suspend fun getCustomersFromNetwork() {

        val data = repository.getAllCustomers()
        if (!data.isNullOrEmpty()) {
            customerDAO.insertAllCustomers(data)
        }

    }
    private suspend fun getCustomersFromDatabase(): MutableList<CustomersData> {
        return customerDAO.getAllCustomers()
    }

}