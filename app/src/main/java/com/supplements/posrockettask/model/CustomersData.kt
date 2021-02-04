package com.supplements.posrockettask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.supplements.posrockettask.model.addresses.Addresses
import com.supplements.posrockettask.model.tags.Discounts
import com.supplements.posrockettask.model.tags.Tags
import java.util.*

@Entity(tableName = "data")
class CustomersData {

    @PrimaryKey
    var id:String=""
    var dob:String? =null
    var tags:MutableList<Tags>? = null
    var email:String?= null
    var gender:String? = null
    var balance:Double?= null
    var country:String? = null
    var comments:String? =  null
    var addresses:MutableList<Addresses>? = null
    var last_name:String?= null
    var created_at: String?=null
    var first_name:String? =null
    var updated_at: String?=null
    var phone_numbers:MutableList<PhoneNumbers>?=null


    override fun toString(): String {
        var phoneNumbers:String? =null
        for (p: PhoneNumbers in phone_numbers.orEmpty()){
            phoneNumbers+= p.toString()
        }
        var addressesList:String? =null
        for (a: Addresses in addresses.orEmpty()){
            addressesList+= a.toString()
        }

        return "$first_name $last_name $gender $country ${addressesList.orEmpty()} ${phoneNumbers.orEmpty()}"
    }


}