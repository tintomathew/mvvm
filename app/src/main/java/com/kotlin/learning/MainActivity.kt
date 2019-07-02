package com.kotlin.learning

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.learning.adapter.CustomAdapter

import com.kotlin.learning.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var recyclerView:RecyclerView?=null
    private var customAdapter: CustomAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var categoryViewModel : CategoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        categoryViewModel.getArrayList().observe(this, Observer {categoryViewModels->

            customAdapter = CustomAdapter(this, categoryViewModels!!)

            my_recycler_view!!.layoutManager = LinearLayoutManager(this)
            my_recycler_view!!.adapter = customAdapter

        })
    }
}
