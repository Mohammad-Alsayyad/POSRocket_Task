package com.supplements.posrockettask.ui.activities.home_page

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.github.pwittchen.networkevents.library.NetworkHelper
import com.supplements.posrockettask.R
import com.supplements.posrockettask.adapter.CustomersAdapter
import com.supplements.posrockettask.helper.HelperClass
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var rvCustomer: RecyclerView
    private var spanCount: Int = 0
    private var isConnected:Boolean?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        setContentView(R.layout.activity_home)



        rvCustomer = findViewById(R.id.rvCustomers)

        spanCount = HelperClass.calcSpanWidth(this, 150.0)
        isConnected= NetworkHelper.isConnectedToWiFiOrMobileNetwork(this)

        buildRVCustomer(spanCount, isConnected!!)
    }

    private fun buildRVCustomer(spanCount:Int,isConnected:Boolean) {

        Toast.makeText(this@HomeActivity, isConnected.toString(), Toast.LENGTH_SHORT).show()

        rvCustomer.layoutManager =
            StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)

        viewModel.getAllCustomers(isConnected).observe(
            this
        ) { it ->
            val adapter = CustomersAdapter(this, it)
            rvCustomer.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }



}