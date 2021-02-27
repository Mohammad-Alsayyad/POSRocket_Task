package com.supplements.posrockettask.api.business.customers.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phone_numbers")
class PhoneNumbers {
    @PrimaryKey
    var id:String =""
    var number:Long? =null
    var is_primary:Boolean=false
    var is_verified:Boolean=false

    constructor(id: String, number: Long?, is_primary: Boolean, is_verified: Boolean) {
        this.id = id
        this.number = number
        this.is_primary = is_primary
        this.is_verified = is_verified
    }

    override fun toString(): String {
        return "$number"
    }


}
