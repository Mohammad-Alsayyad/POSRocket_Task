package com.supplements.posrockettask.ui.activities.home_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.supplements.posrockettask.R
import com.supplements.posrockettask.helper.HelperClass

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var rvCustomer: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        setContentView(R.layout.activity_home)

        rvCustomer =findViewById(R.id.rvCustomers)
        buildRVCustomer()
    }

    private fun buildRVCustomer() {

        var spanWidth: Int = HelperClass.calcSpanWidth(this,150.0)
        rvCustomer.layoutManager = StaggeredGridLayoutManager(spanWidth, StaggeredGridLayoutManager.VERTICAL)


    }
}