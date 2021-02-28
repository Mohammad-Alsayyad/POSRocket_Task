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

class HomeViewModel constructor(var repository: CustomersRepository, var customerDAO: CustomerDAO) : ViewModel() {


    fun getAllCustomers() :LiveData<MutableList<CustomersData>> {

        var customersList: MutableLiveData<MutableList<CustomersData>> =
            MutableLiveData<MutableList<CustomersData>>()

        viewModelScope.launch(Dispatchers.IO) {

            val api:Job = launch { getCustomersFromNetwork() }
            api.join()

            withContext(Dispatchers.Main) {
                customersList.value =getCustomersFromDatabase()
            }

        }
        return customersList

    }

    private suspend fun getCustomersFromNetwork(){

       val data =  repository.getAllCustomers()
        if (!data.isNullOrEmpty()){
            customerDAO.insertAllCustomers(data)
        }

    }
    private suspend fun getCustomersFromDatabase(): MutableList<CustomersData> {
        return customerDAO.getAllCustomers()
    }

}