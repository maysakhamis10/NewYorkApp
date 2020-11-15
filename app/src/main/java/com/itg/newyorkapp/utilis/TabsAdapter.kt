package com.example.newyorktimes.utilis

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.itg.newyorkapp.views.BookMarksFragment
import com.itg.newyorkapp.views.NewFeedsFragment


internal class TabsAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                NewFeedsFragment()
            }
            1 -> {
                BookMarksFragment()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}