package com.supplements.posrockettask.api.business.customers

import com.supplements.posrockettask.api.business.customers.model.Customer
import com.supplements.posrockettask.general.AppConstants
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CustomersService {

    @GET(AppConstants.CUSTOMERS_DATA)
    fun getAllCustomers(): Single<Customer>
}