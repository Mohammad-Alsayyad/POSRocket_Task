package com.supplements.posrockettask.api.business.customers.model.addresses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "avenue")
class Avenue {

    @PrimaryKey
    var id: String=""
    var ar: String? = null
    var en: String? = null


}