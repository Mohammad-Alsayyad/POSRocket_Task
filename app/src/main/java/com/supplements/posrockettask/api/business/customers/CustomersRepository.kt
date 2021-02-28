package com.supplements.posrockettask.api.business.customers


import com.supplements.posrockettask.api.business.customers.model.CustomersData
import java.lang.Exception


class CustomersRepository constructor(var service: CustomersService) {

    suspend fun getAllCustomers(): MutableList<CustomersData>? {
        return try {
            service.getAllCustomers().data

        }catch (e:Exception)
        {
            null
        }
    }


}
