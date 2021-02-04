package com.supplements.posrockettask.ui.activities.home_page

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.github.pwittchen.networkevents.library.NetworkHelper
import com.supplements.posrockettask.R
import com.supplements.posrockettask.adapter.CustomersAdapter
import com.supplements.posrockettask.helper.HelperClass
import com.supplements.posrockettask.ui.activities.customer_page.AddCustomerActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var rvCustomer: RecyclerView
    private var spanCount: Int = 0
    private var isConnected: Boolean? = null
    private lateinit var adapter:CustomersAdapter
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        setContentView(R.layout.activity_home)

        rvCustomer = findViewById(R.id.rvCustomers)
        toolbar = findViewById(R.id.toolbarHomePage)

        toolbar.title = ""
        toolbar.setNavigationIcon(R.drawable.ic_add_account)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this@HomeActivity, AddCustomerActivity::class.java))
        }

        spanCount = HelperClass.calcSpanWidth(this, 150.0)
        isConnected = NetworkHelper.isConnectedToWiFiOrMobileNetwork(this)

        buildRVCustomer(spanCount, isConnected!!)
    }

    private fun buildRVCustomer(spanCount: Int, isConnected: Boolean) {

        Toast.makeText(this@HomeActivity, isConnected.toString(), Toast.LENGTH_SHORT).show()

        rvCustomer.layoutManager =
            StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)

        viewModel.getAllCustomers(isConnected).observe(
            this
        ) { it ->
             adapter = CustomersAdapter(this, it)
            rvCustomer.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_home, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = searchItem?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                callSearch(query)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                callSearch(newText)
                return true
            }
            fun callSearch(query: String?) {
                adapter.getFilter().filter(query);
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

}