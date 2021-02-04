package com.supplements.posrockettask.room_database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.supplements.posrockettask.model.PhoneNumbers
import com.supplements.posrockettask.model.addresses.*
import com.supplements.posrockettask.model.tags.Discounts
import com.supplements.posrockettask.model.tags.Tags
import java.io.Serializable
import java.lang.reflect.Type


class DataConverter :Serializable {

    @TypeConverter
    fun fromPhoneNumbers(phoneNumbers: MutableList<PhoneNumbers?>?): String? {
        if (phoneNumbers == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<PhoneNumbers?>?>() {}.type
        return gson.toJson(phoneNumbers, type)
    }

    @TypeConverter
    fun toPhoneNumbers(phoneNumbersString: String?): MutableList<PhoneNumbers>? {
        if (phoneNumbersString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<PhoneNumbers?>?>() {}.type
        return gson.fromJson<MutableList<PhoneNumbers>>(phoneNumbersString, type)
    }


    @TypeConverter
    fun fromTags(tags: MutableList<Tags?>?): String? {
        if (tags == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<Tags?>?>() {}.type
        return gson.toJson(tags, type)
    }

    @TypeConverter
    fun toTags(tagsString: String?): MutableList<Tags>? {
        if (tagsString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<Tags?>?>() {}.type
        return gson.fromJson<MutableList<Tags>>(tagsString, type)
    }

    @TypeConverter
    fun fromDiscounts(discounts: MutableList<Discounts?>?): String? {
        if (discounts == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<Discounts?>?>() {}.type
        return gson.toJson(discounts, type)
    }

    @TypeConverter
    fun toDiscounts(discountsString: String?): MutableList<Discounts>? {
        if (discountsString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<Discounts?>?>() {}.type
        return gson.fromJson<MutableList<Discounts>>(discountsString, type)
    }



    @TypeConverter
    fun fromAddresses(addresses: MutableList<Addresses?>?): String? {
        if (addresses == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<Addresses?>?>() {}.type
        return gson.toJson(addresses, type)
    }

    @TypeConverter
    fun toAddresses(addressesString: String?): MutableList<Addresses>? {
        if (addressesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<Addresses?>?>() {}.type
        return gson.fromJson<MutableList<Addresses>>(addressesString, type)
    }


    @TypeConverter
    fun fromCity(city: City?): String? {
        if (city == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<City?>() {}.type
        return gson.toJson(city, type)
    }

    @TypeConverter
    fun toCity(cityString: String?): City? {
        if (cityString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<City?>() {}.type
        return gson.fromJson<City>(cityString, type)
    }


    @TypeConverter
    fun fromPosition(position: Position?): String? {
        if (position == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Position?>() {}.type
        return gson.toJson(position, type)
    }

    @TypeConverter
    fun toPosition(positionString: String?): Position? {
        if (positionString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Position?>() {}.type
        return gson.fromJson<Position>(positionString, type)
    }


    @TypeConverter
    fun fromAvenue(avenue: Avenue?): String? {
        if (avenue == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Avenue?>() {}.type
        return gson.toJson(avenue, type)
    }

    @TypeConverter
    fun toAvenue(avenueString: String?): Avenue? {
        if (avenueString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Avenue?>() {}.type
        return gson.fromJson<Avenue>(avenueString, type)
    }


    @TypeConverter
    fun fromBlock(block: Block?): String? {
        if (block == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Block?>() {}.type
        return gson.toJson(block, type)
    }

    @TypeConverter
    fun toBlock(blockString: String?): Block? {
        if (blockString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Block?>() {}.type
        return gson.fromJson<Block>(blockString, type)
    }

    @TypeConverter
    fun fromArea(area: Area?): String? {
        if (area == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Area?>() {}.type
        return gson.toJson(area, type)
    }

    @TypeConverter
    fun toArea(areaString: String?): Area? {
        if (areaString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Area?>() {}.type
        return gson.fromJson<Area>(areaString, type)
    }


}