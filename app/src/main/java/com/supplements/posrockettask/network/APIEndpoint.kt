package com.supplements.posrockettask.network

import com.supplements.posrockettask.general.AppConstants.CUSTOMERS_DATA
import com.supplements.posrockettask.model.Customer
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface APIEndpoint {

    @GET(CUSTOMERS_DATA)
    fun getAllCustomers(): Single<Customer>
}
