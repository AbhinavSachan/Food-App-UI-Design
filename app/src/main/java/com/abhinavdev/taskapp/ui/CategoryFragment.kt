package com.abhinavdev.taskapp.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhinavdev.taskapp.R
import com.abhinavdev.taskapp.databinding.CategoryItemLayoutBinding
import com.abhinavdev.taskapp.models.VendorsItem
import com.abhinavdev.taskapp.scripts.LinearLayoutManagerWrapper
import com.abhinavdev.taskapp.ui.adapters.FoodItemAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {
    private val b by lazy {
        CategoryItemLayoutBinding.inflate(layoutInflater)
    }

    // TODO: Rename and change types of parameters
    private var vendorsItem: VendorsItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                vendorsItem = it.getSerializable(ARG_PARAM1,VendorsItem::class.java)
            }else{
                vendorsItem = it.getSerializable(ARG_PARAM1) as VendorsItem
            }
        }
        b.categoryName.text = vendorsItem?.vendorCategoryName
        b.productRecyclerView.layoutManager = LinearLayoutManagerWrapper(context,
            LinearLayoutManager.VERTICAL,false)
        b.productRecyclerView.setHasFixedSize(true)
        b.productRecyclerView.adapter = FoodItemAdapter(vendorsItem?.items,requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return b.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: VendorsItem?) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}