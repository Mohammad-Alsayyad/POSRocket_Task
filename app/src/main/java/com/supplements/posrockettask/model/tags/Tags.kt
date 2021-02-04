package com.supplements.posrockettask.model.tags

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
class Tags {

    @PrimaryKey
    var id:String=""
    var name:String? = null
    var discounts:MutableList<Discounts>?=null

    constructor(id: String, name: String?, discounts: MutableList<Discounts>?) {
        this.id = id
        this.name = name
        this.discounts = discounts
    }


    override fun toString(): String {
        var discountsList:String? =null
        for (d: Discounts in discounts.orEmpty()){
            discountsList+= d.toString()
        }
        return "$name \n ${discountsList.orEmpty()} \n"
    }
}