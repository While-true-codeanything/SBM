package com.egor.sbm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    fun loadFragment(fragment: Fragment, id: Int) {
        val ft =
            supportFragmentManager.beginTransaction()
        ft.replace(id, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_plus -> {
                    title = "Доходы"
                    /* loadFragment(MainPageFragment())*/
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_min -> {
                    title = "Расходы"
                    /* loadFragment(SettingsFragment())*/
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_all -> {
                    title = "Все"
                    /*  loadFragment(AppSettingsFragment())*/
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
        navigation.selectedItemId = R.id.navigation_all
    }
}