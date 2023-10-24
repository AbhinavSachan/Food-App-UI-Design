package com.abhinavdev.taskapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.abhinavdev.taskapp.R
import com.abhinavdev.taskapp.databinding.ActivityMainBinding
import com.abhinavdev.taskapp.models.Data
import com.abhinavdev.taskapp.models.Result
import com.abhinavdev.taskapp.modules.ApiModule
import com.abhinavdev.taskapp.services.Service
import com.abhinavdev.taskapp.ui.adapters.VerticalViewCategoryAdapter
import com.abhinavdev.taskapp.utils.ApiClient
import com.abhinavdev.taskapp.utils.ImageLoadingUtil
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener,ViewPager.OnPageChangeListener {

    private var adapter: VerticalViewCategoryAdapter? = null
    private val b by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.ivBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        b.categoryTabs.addOnTabSelectedListener(this)
        getData()
        b.appBarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            if (Math.abs(verticalOffset) == b.appBarLayout.totalScrollRange) {
                // collapsed
                b.pageTitle.alpha = 1f
            } else if (verticalOffset == 0) {
                // Expanded
                b.pageTitle.alpha = 0f
            } else {
                // Toolbar is not fully collapsed
                Log.d("TAG", "${-verticalOffset / 1000f}")
                b.pageTitle.alpha = -verticalOffset / 1000f
            }
        }
        b.categoryRecView.setOnPageChangeListener(this)

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        b.categoryTabs.selectTab(b.categoryTabs.getTabAt(position))
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    private fun getData() {
        val service = ApiClient.client?.create(Service::class.java)
        val call = service?.getData()
        call?.enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (response.code() == 200) {
                    val result = response.body()
                    ApiModule.setData(result?.data)
                    setDataInUi(result?.data)
                    for (name in result?.data?.vendorsDetail?.vendorCategories!!) {
                        setTab(name)
                    }
                } else {
                    toast(null)
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                toast(t.message)
                t.printStackTrace()
            }
        })
    }

    private fun setTab(name: String?) {
        b.categoryTabs.apply {
            addTab(newTab().setText(name))
        }
    }

    private fun toast(msg: String?) {
        Toast.makeText(this, msg ?: "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab?.let { b.categoryRecView.setCurrentItem(it.position, true) }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onDestroy() {
        super.onDestroy()
        b.categoryTabs.removeOnTabSelectedListener(this)
    }

    @SuppressLint("SetTextI18n")
    private fun setDataInUi(data: Data?) {
        val businessName = data?.vendorsDetail?.name
        val businessDes = data?.vendorsDetail?.description
        b.pageTitle.text = businessName
        b.businessName.text = businessName
        b.businessDes.text = businessDes
        b.avgRating.text = data?.vendorsDetail?.avgRating?.toDouble().toString()
        b.totalRating.text = "(${data?.vendorsDetail?.totalRatings + 50}+ Ratings)"
        b.deliveryFee.text = "KD 0.500"
        b.deliveryTime.text = "25 mins"
        b.deliveredBy.text = "talabat"
        ImageLoadingUtil.loadFromApiUrl(
            data?.vendorsDetail?.logo,
            R.drawable.placeholder,
            R.drawable.error_place_holder,
            b.businessLogo
        )
        ImageLoadingUtil.loadFromApiUrl(
            data?.vendorsDetail?.banner,
            R.drawable.placeholder,
            R.drawable.error_place_holder,
            b.bannerImg
        )
//        b.categoryRecView.layoutManager = LinearLayoutManagerWrapper(
//            this,
//            LinearLayoutManager.VERTICAL, false
//        )
//        b.categoryRecView.setHasFixedSize(true)
        adapter = VerticalViewCategoryAdapter(data?.vendorsItems, supportFragmentManager)
        b.categoryRecView.adapter = adapter
    }
}