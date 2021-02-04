package com.supplements.posrockettask.ui.activities.home_page

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.supplements.posrockettask.model.CustomersData
import com.supplements.posrockettask.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel @ViewModelInject constructor(var repository: Repository) : ViewModel() {



    fun getAllCustomers(isConnected:Boolean): LiveData<MutableList<CustomersData>> {
       return repository.getAllCustomers(isConnected)
   }




}