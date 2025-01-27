package com.intern.xtrade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.intern.xtrade.Adapters.FragmentPageAdapter

class Buy_activity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout
    lateinit var adapter : FragmentPageAdapter
    lateinit var BuyToolBar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buy_activity)
         viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tab_layout)
        BuyToolBar = findViewById(R.id.BuyStockToolBar)
        setActionBar(BuyToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        adapter = FragmentPageAdapter(supportFragmentManager ,lifecycle)

        viewPager.adapter = adapter
        Log.i("TABCHECK","${10}")

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    Log.i("TABCHECK","${it.position}")
                    viewPager.currentItem = it.position;
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}