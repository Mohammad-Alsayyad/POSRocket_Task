package com.supplements.posrockettask.api.business.customers

import org.koin.dsl.module
import retrofit2.Retrofit

val customersRepository = module {
    factory { createCustomersApiService(get()) }
    factory { CustomersRepository(get(),get()) }
}

fun createCustomersApiService(retrofit: Retrofit): CustomersService =
        retrofit.create(CustomersService::class.java)