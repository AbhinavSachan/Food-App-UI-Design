package com.abhinavdev.taskapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinavdev.taskapp.R
import com.abhinavdev.taskapp.databinding.CategoryItemLayoutBinding
import com.abhinavdev.taskapp.models.VendorsItem
import com.abhinavdev.taskapp.scripts.LinearLayoutManagerWrapper

class CategoryAdapter(val categoryList:List<VendorsItem>?, val context:Context): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CategoryItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categoryList?.get(position)
        holder.bind(item,position)
    }

    override fun getItemCount(): Int {
        return categoryList?.size?: 0
    }

    inner class ViewHolder(val b: CategoryItemLayoutBinding) : RecyclerView.ViewHolder(b.root){
        fun bind(vendorItem:VendorsItem?,position: Int){
            b.categoryName.text = vendorItem?.vendorCategoryName
            b.productRecyclerView.layoutManager = LinearLayoutManagerWrapper(context,LinearLayoutManager.VERTICAL,false)
            b.productRecyclerView.setHasFixedSize(true)
            b.productRecyclerView.adapter = FoodItemAdapter(vendorItem?.items,context)
        }
    }
}