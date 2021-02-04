package com.supplements.posrockettask.model.addresses

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "city")
class City {

    @PrimaryKey
    var id:String=""
    var ar:String? =null
    var en:String? =null

    override fun toString(): String {
        return "$ar $en"
    }
}