package com.supplements.posrockettask.model.tags

class Tags {


    var id:String? =null
    var name:String? = null
    var discounts:MutableList<Discounts>?=null

    override fun toString(): String {
        var discountsList:String? =null
        for (d:Discounts in discounts.orEmpty()){
            discountsList+= d.toString()
        }
        return "$name \n ${discountsList.orEmpty()} \n"
    }
}