package com.supplements.posrockettask.api.business.customers.model.addresses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "addresses")
class Addresses {

    @PrimaryKey
    var id:String=""
    var area: Area? =null
    var city: City? = null
    var block: Block? = null
    var floor:String? = null
    var label:String?= null
    var avenue: Avenue? = null
    var extras:String? = null
    var street:String? = null
    var building:String? = null
    var position: Position? = null
    var apartment:String? = null
    var residence:String? = null
    var is_primary:Boolean=false
    var is_verified:Boolean=false

    constructor(
        id: String,
        area: Area?,
        city: City?,
        block: Block?,
        floor: String?,
        label: String?,
        avenue: Avenue?,
        extras: String?,
        street: String?,
        building: String?,
        position: Position?,
        apartment: String?,
        residence: String?,
        is_primary: Boolean,
        is_verified: Boolean
    ) {
        this.id = id
        this.area = area
        this.city = city
        this.block = block
        this.floor = floor
        this.label = label
        this.avenue = avenue
        this.extras = extras
        this.street = street
        this.building = building
        this.position = position
        this.apartment = apartment
        this.residence = residence
        this.is_primary = is_primary
        this.is_verified = is_verified
    }

    override fun toString(): String {

        return "$area $city $block $street"
    }


}
