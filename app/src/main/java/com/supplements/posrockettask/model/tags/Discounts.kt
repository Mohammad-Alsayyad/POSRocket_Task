package com.supplements.posrockettask.model.tags

class Discounts {


    var id: String? = null
    var name: String? = null
    var rate: Double? = null
    var type: String? = null
    var color: String? = null
    var amount: Int? = null
    var after_tax: Boolean? = null
    var pin_required: Boolean? = null

    override fun toString(): String {
        return "${name.orEmpty()} ${rate?.toString().orEmpty()} ${type.orEmpty()} " +
                "${color.orEmpty()} ${amount?.toString().orEmpty()}" +
                " \n"
    }

}