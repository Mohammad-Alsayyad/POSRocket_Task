package com.supplements.posrockettask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.supplements.posrockettask.R
import com.supplements.posrockettask.model.CustomersData
import com.supplements.posrockettask.model.PhoneNumbers
import com.supplements.posrockettask.model.tags.Tags
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

class CustomersAdapter(
    var context: Context,
    private var customersData: MutableList<CustomersData>
) :
    RecyclerView.Adapter<CustomersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_customer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // set gender image
        val drawableId: Int = getDrawableId(customersData[position].gender!!)
        holder.imgGender.setImageResource(drawableId)

        // set full name
        var lastname: String = customersData[position].last_name.orEmpty()
        var firstName: String = customersData[position].first_name.orEmpty()
        var fullName: String = context.resources.getString(R.string.full_name, firstName, lastname)
        holder.tvFullName.text = fullName

        // get primary phone number
        holder.tvPhoneNo.text = getPrimaryNumber(customersData[position].phone_numbers)

        // balance (rounded by 3 digits)
        holder.tvBalance.text = roundedBy3Digits(customersData[position].balance)

        // Tags
        holder.tvTags.text = formatTags(customersData[position].tags)

    }

    private fun formatTags(tags: MutableList<Tags>?): String? {
        var tagsList: String? = null
        for (tag: Tags in tags.orEmpty()) {
            tagsList += tag.toString()
        }
        return tagsList
    }

    private fun roundedBy3Digits(balance: Double?): String? {
        return BigDecimal(balance!!).setScale(3, RoundingMode.HALF_EVEN).toString()
    }

    private fun getDrawableId(genderName: String): Int {
        val gender: String = genderName.toLowerCase(Locale.ROOT)
        val icName: String = context.resources.getString(R.string.base_ic_name, gender)
        return context.resources.getIdentifier(icName, "drawable", context.packageName)
    }

    private fun getPrimaryNumber(phoneNumbers: MutableList<PhoneNumbers>?): String {

        var primaryPhoneNo: Long? = null
        phoneNumbers?.forEach { it ->
            if (it.is_primary == true) {
                primaryPhoneNo = it.number
            }
        }
        return primaryPhoneNo?.toString().orEmpty()
    }


    override fun getItemCount(): Int {
        return customersData.size
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        var imgGender: ImageView
        var tvFullName: TextView
        var tvPhoneNo: TextView
        var tvBalance: TextView
        var tvTags: TextView

        init {

            imgGender = view.findViewById(R.id.imgGender)
            tvFullName = view.findViewById(R.id.tvFullName)
            tvPhoneNo = view.findViewById(R.id.tvPhoneNo)
            tvBalance = view.findViewById(R.id.tvBalance)
            tvTags = view.findViewById(R.id.tvTags)
        }

    }
}