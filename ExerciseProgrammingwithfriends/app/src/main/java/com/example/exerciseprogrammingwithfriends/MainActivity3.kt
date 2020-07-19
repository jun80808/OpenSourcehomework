package com.example.exerciseprogrammingwithfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import android.view.View
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class MainActivity3 : AppCompatActivity() {
// ...
// Initialize Firebase Auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        initView()
                // ...
            }
    }
    fun createView(tabName:String): View {
        val tabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        tabView.text_custom.text = tabName
        when (tabName) {
            "코틀린" -> {
                tabView.image_custom.setImageResource(R.drawable.ic_android_black_24dp)
            }
            "겁나" -> {
                tabView.image_custom.setImageResource(R.drawable.ic_baseline_airplanemode_active_24)
            }
            "어렵다"->{
                tabView.image_custom.setImageResource(R.drawable.ic_baseline_child_care_24)
            }
            else -> {
                return tabView
            }
        }
        return tabView
    }


    fun initView(){
        val fragment = fragment()
        val fragment2 = fragment()
        val fragment3 = fragment()
        val adapters = pagerAdapter(supportFragmentManager)
        adapters.addItems(fragment)
        adapters.addItems(fragment2)
        adapters.addItems(fragment3)
        viewpager3.adapter = adapters
        tablayout3.setupWithViewPager(viewpager3)
        //Tab의 0번째 인덱스를 가져와서 aa 라는 이름을 지어줌
        tablayout3.getTabAt(0)?.setCustomView(createView("코틀린"))
        tablayout3.getTabAt(1)?.setCustomView(createView("겁나"))
        tablayout3.getTabAt(2)?.setCustomView(createView("어렵다"))
    }

    private inner class pagerAdapter(fragmentmanager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentmanager) {
        private val fragments: ArrayList<Fragment> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addItems(item: Fragment) {
            fragments.add(item)
        }
    }
}