package com.itg.newyorkapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.newyorktimes.utilis.TabsAdapter
import com.google.android.material.tabs.TabLayout
import com.itg.newyorkapp.R


class MainActivity : AppCompatActivity()  {


    //init views
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }


    private fun initViews() {
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText(R.string.new_feeds))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.bookmarks))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = TabsAdapter(
            this, supportFragmentManager,
            tabLayout.tabCount
        )
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}