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
    fun fromPhoneNumbers(countryLang: MutableList<PhoneNumbers?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<PhoneNumbers?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toPhoneNumbers(countryLangString: String?): MutableList<PhoneNumbers>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<PhoneNumbers?>?>() {}.type
        return gson.fromJson<MutableList<PhoneNumbers>>(countryLangString, type)
    }


    @TypeConverter
    fun fromTags(countryLang: MutableList<Tags?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<Tags?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toTags(countryLangString: String?): MutableList<Tags>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<Tags?>?>() {}.type
        return gson.fromJson<MutableList<Tags>>(countryLangString, type)
    }

    @TypeConverter
    fun fromDiscounts(countryLang: MutableList<Discounts?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<Discounts?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toDiscounts(countryLangString: String?): MutableList<Discounts>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<Discounts?>?>() {}.type
        return gson.fromJson<MutableList<Discounts>>(countryLangString, type)
    }



    @TypeConverter
    fun fromAddresses(countryLang: MutableList<Addresses?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<MutableList<Addresses?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toAddresses(countryLangString: String?): MutableList<Addresses>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<Addresses?>?>() {}.type
        return gson.fromJson<MutableList<Addresses>>(countryLangString, type)
    }


    @TypeConverter
    fun fromCity(countryLang: City?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<City?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCity(countryLangString: String?): City? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<City?>() {}.type
        return gson.fromJson<City>(countryLangString, type)
    }


    @TypeConverter
    fun fromPosition(countryLang: Position?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Position?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toPosition(countryLangString: String?): Position? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Position?>() {}.type
        return gson.fromJson<Position>(countryLangString, type)
    }


    @TypeConverter
    fun fromAvenue(countryLang: Avenue?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Avenue?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toAvenue(countryLangString: String?): Avenue? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Avenue?>() {}.type
        return gson.fromJson<Avenue>(countryLangString, type)
    }


    @TypeConverter
    fun fromBlock(countryLang: Block?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Block?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toBlock(countryLangString: String?): Block? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Block?>() {}.type
        return gson.fromJson<Block>(countryLangString, type)
    }

    @TypeConverter
    fun fromArea(countryLang: Area?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type? = object : TypeToken<Area?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toArea(countryLangString: String?): Area? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Area?>() {}.type
        return gson.fromJson<Area>(countryLangString, type)
    }


}