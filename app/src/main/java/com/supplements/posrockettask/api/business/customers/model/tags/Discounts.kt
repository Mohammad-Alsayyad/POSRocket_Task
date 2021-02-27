package com.supplements.posrockettask.api.business.customers.model.tags

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "discounts")
class Discounts {

    @PrimaryKey
    var id: String=""
    var name: String? = null
    var rate: Double? = null
    var type: String? = null
    var color: String? = null
    var amount: Int? = null
    var after_tax: Boolean? = null
    var pin_required: Boolean? = null




    override fun toString(): String {
        return "${name.orEmpty()} ${rate?.toString().orEmpty()} ${type.orEmpty()} " +
                "${color.orEmpty()} ${amount?.toString().orEmpty()} \n "
    }

}