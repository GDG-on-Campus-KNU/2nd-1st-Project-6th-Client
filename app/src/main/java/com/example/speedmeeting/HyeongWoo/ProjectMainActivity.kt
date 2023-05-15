package com.example.speedmeeting.HyeongWoo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.speedmeeting.R
import com.example.speedmeeting.databinding.ProjectHomeLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProjectMainActivity : AppCompatActivity() {
    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init {
            fragments= listOf(HomeFragment(), CategoryFragment(), MyPageFragment())
            Log.d("choi","fragments size : ${fragments.size}")
        }
        override fun getItemCount(): Int = fragments.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ProjectHomeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager = binding.viewPager2
        val bottomNavigationView = binding.bottomNav

        val adapter = MyFragmentPagerAdapter(this) // 사용자 정의 어댑터를 생성합니다.
        viewPager.adapter = adapter

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_tab -> viewPager.currentItem = 0
                R.id.category_tab -> viewPager.currentItem = 1
                R.id.my_page_tab -> viewPager.currentItem = 2
            }
            true
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigationView.selectedItemId = when (position) {
                    0 -> R.id.home_tab
                    1 -> R.id.category_tab
                    2 -> R.id.my_page_tab
                    else -> throw IllegalArgumentException("Invalid position: $position")
                }
            }
        })
        val myButton = binding.button
        myButton.setOnClickListener {
            // 버튼 클릭 시 실행할 로직을 여기에 작성합니다.
            setContentView(R.layout.loading_layout)
        }
    }
}