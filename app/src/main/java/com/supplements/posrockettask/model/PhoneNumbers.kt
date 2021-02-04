package com.supplements.posrockettask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import javax.annotation.Nullable

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
}
