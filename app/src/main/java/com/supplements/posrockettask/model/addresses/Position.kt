package com.supplements.posrockettask.model.addresses

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "position")
class Position {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
    var latitude:Double? = null
    var longitude:Double? = null


}