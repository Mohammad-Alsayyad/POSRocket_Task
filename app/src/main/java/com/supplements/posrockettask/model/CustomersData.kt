package com.supplements.posrockettask.model

import com.supplements.posrockettask.model.addresses.Addresses
import com.supplements.posrockettask.model.tags.Tags
import java.util.*

class CustomersData {

    var id:String? = null
    var dob:String? =null
    var tags:MutableList<Tags>? = null
    var email:String?= null
    var gender:String? = null
    var balance:Double?= null
    var country:String? = null
    var comments:String? =  null
    var addresses:MutableList<Addresses>? = null
    var last_name:String?= null
    var created_at: Date?=null
    var first_name:String? =null
    var updated_at: Date?=null
    var phone_numbers:MutableList<PhoneNumbers>?=null
}