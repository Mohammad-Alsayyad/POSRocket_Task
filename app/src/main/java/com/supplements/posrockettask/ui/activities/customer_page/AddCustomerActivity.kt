package com.supplements.posrockettask.ui.activities.customer_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import com.supplements.posrockettask.R

class AddCustomerActivity : AppCompatActivity() {

    private lateinit var tvFirstName: TextInputLayout
    private lateinit var tvLastName: TextInputLayout
    private lateinit var tvEmail: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        tvFirstName = findViewById(R.id.tv_layout_first_name)
        tvLastName = findViewById(R.id.tv_layout_last_name)
        tvEmail = findViewById(R.id.tv_layout_email)

        tvFirstName.setStartIconTintList(ContextCompat.getColorStateList(this, R.color.blue))
        tvLastName.setStartIconTintList(ContextCompat.getColorStateList(this, R.color.blue))
        tvEmail.setStartIconTintList(ContextCompat.getColorStateList(this, R.color.blue))
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