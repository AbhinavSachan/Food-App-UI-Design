package com.abhinavdev.taskapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.abhinavdev.taskapp.models.VendorsItem
import com.abhinavdev.taskapp.ui.CategoryFragment

class VerticalViewCategoryAdapter(
    val categoryList: List<VendorsItem>?, fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return categoryList?.size ?: 0
    }

    override fun getItem(position: Int): Fragment {
        return CategoryFragment.newInstance(categoryList?.get(position))
    }
}