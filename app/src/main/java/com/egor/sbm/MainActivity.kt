package com.egor.sbm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    fun loadFragment(fragment: Fragment) {
        val ft =
            supportFragmentManager.beginTransaction()
        ft.replace(R.id.place, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<DataItem>()
        MemoryAccesser(this)
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_plus -> {
                    title = "Доходы"
                    loadFragment(ListFragment(1))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_min -> {
                    title = "Расходы"
                    loadFragment(ListFragment(2))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_all -> {
                    title = "Все"
                    loadFragment(AllFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
        navigation.selectedItemId = R.id.navigation_all
    }
}