package com.supplements.posrockettask.ui.activities.home_page

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
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
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var rvCustomer: RecyclerView
    private var spanCount: Int = 0
    private lateinit var adapter: CustomersAdapter
    private lateinit var toolbar: Toolbar
    lateinit var progressBar: ProgressBar
    lateinit var container: RelativeLayout
    lateinit var params: RelativeLayout.LayoutParams


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvCustomer = findViewById(R.id.rv_customers)
        toolbar = findViewById(R.id.toolbar_home)
        container = findViewById(R.id.container)

        // ToolBar
        toolbar.title = ""
        toolbar.setNavigationIcon(R.drawable.ic_add_account)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this@HomeActivity, AddCustomerActivity::class.java))
        }
        // Add progress bar
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        params = RelativeLayout.LayoutParams(150, 150)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)

        // detect span count
        spanCount = HelperClass.calcSpanWidth(this, 150.0)
        // check internet connection

        buildRVCustomer(spanCount)
    }

    private fun buildRVCustomer(spanCount: Int) {

        container.addView(progressBar, params)

        rvCustomer.layoutManager =
            StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)

        viewModel.getAllCustomers().observe(
            this
        ) { it ->
            adapter = CustomersAdapter(this, it)
            rvCustomer.adapter = adapter
            progressBar.visibility = View.GONE
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
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        callSearch(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        callSearch(newText)
        return true
    }

    private fun callSearch(query: String?) {

        if (this::adapter.isInitialized) {
            adapter.getFilter().filter(query)
        }
    }

}