package com.kotlin.learning.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.learning.R
import com.kotlin.learning.databinding.CategoryBinding
import com.kotlin.learning.viewmodel.CategoryViewModel

class CustomAdapter(private val context: Context, private val arrayList: ArrayList<CategoryViewModel>):
    RecyclerView.Adapter<CustomAdapter.CustomView>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomView {
        val layoutInflater = LayoutInflater.from(context)

        val categoryBinding: CategoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item, p0, false)

        return CustomView(categoryBinding)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(p0: CustomView, p1: Int) {


        val categoryViewModel = arrayList[p1]
        p0.bind(categoryViewModel)
    }

    class CustomView(val categoryBinding: CategoryBinding): RecyclerView.ViewHolder(categoryBinding.root){
    fun bind(categoryViewModel: CategoryViewModel) {

        this.categoryBinding.categoryModel = categoryViewModel
        categoryBinding.executePendingBindings()

    }
   }

}