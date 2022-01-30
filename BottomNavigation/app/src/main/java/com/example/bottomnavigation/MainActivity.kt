package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val menuFragment by lazy { MenuFragment() }
    private val cartFragment by lazy { CartFragment() }
    private val my100Fragment by lazy { My100Fragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(menuFragment)

        menuFragment.selectedItemId = R.id.menu

//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.menu -> {
//                    setFragment(menuFragment)
//                    true
//                }
//                R.id.cart -> {
//                    setFragment(cartFragment)
//                    true
//                }
//                R.id.my100 -> {
//                    setFragment(my100Fragment)
//                    true
//                }
//                else -> false
//            }
//        }
    }

    fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, menuFragment)
        transaction.commit()
    }
}