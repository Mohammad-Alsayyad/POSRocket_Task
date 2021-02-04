package com.supplements.posrockettask.ui.activities.customer_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.supplements.posrockettask.R

class AddCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_add_customer, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)

            }
        }
    }
}