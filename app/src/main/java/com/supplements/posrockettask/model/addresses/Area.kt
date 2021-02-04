package com.supplements.posrockettask.model.addresses

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "area")
class Area {

    @PrimaryKey
    var id:String=""
    var ar:String?=null
    var en:String?=null


}