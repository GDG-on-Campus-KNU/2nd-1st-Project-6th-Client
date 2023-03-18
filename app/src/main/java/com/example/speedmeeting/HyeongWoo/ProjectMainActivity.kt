package com.example.speedmeeting.HyeongWoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
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

        val adapter = MyFragmentPagerAdapter(this)
        binding.viewPager2.adapter = adapter
    }
}