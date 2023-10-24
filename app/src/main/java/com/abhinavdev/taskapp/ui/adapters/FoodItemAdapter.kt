package com.abhinavdev.taskapp.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhinavdev.taskapp.R
import com.abhinavdev.taskapp.databinding.FoodItemLayoutBinding
import com.abhinavdev.taskapp.models.Item
import com.abhinavdev.taskapp.utils.ImageLoadingUtil

class FoodItemAdapter(val foodList: List<Item>?, val context: Context) :
    RecyclerView.Adapter<FoodItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FoodItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = foodList?.get(position)
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return foodList?.size ?: 0
    }

    inner class ViewHolder(val b: FoodItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Item?, position: Int) {
            if(position == foodList!!.size - 1){
                b.productDividerLine.visibility = View.GONE
            }else{
                b.productDividerLine.visibility = View.VISIBLE
            }
            b.productName.text = item?.name
            b.productDescription.text = item?.description
            val price = item?.servicePrice
            if (price != null && price > 0.0) {
                b.productPrice.text = "KD $price"
            } else {
                b.productPrice.text = "Price on selection"
            }
            ImageLoadingUtil.loadFromApiUrl(
                item?.icon,
                R.drawable.placeholder,
                R.drawable.error_place_holder,
                b.productImage
            )
        }
    }
}