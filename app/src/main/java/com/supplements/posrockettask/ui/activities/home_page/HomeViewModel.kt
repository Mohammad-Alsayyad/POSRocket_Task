package com.supplements.posrockettask.ui.activities.home_page

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.supplements.posrockettask.api.business.customers.CustomersRepository
import com.supplements.posrockettask.api.business.customers.model.CustomersData
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModel = module {
    viewModel {
        HomeViewModel(get())
    }
}
class HomeViewModel constructor(var repository: CustomersRepository) : ViewModel() {


    fun getAllCustomers(isConnected:Boolean): LiveData<MutableList<CustomersData>> {

       return repository.getAllCustomers(isConnected)
   }

}