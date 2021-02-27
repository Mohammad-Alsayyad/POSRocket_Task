package com.supplements.posrockettask.api.business.customers.model.addresses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "position")
class Position {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
    var latitude:Double? = null
    var longitude:Double? = null


}