package com.kyawt.mycollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kyawt.mycollection.view.ui.AccountFragment
import com.kyawt.mycollection.view.ui.CollectionFragment
import com.kyawt.mycollection.view.ui.HomeFragment
import com.kyawt.mycollection.view.ui.PhotoDetailFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.fragment_photo_detail.*

class MainActivity : AppCompatActivity() {
    lateinit var view: View
    lateinit var homeFragment : HomeFragment
    lateinit var collectionFragment : CollectionFragment
    lateinit var accountFragment: AccountFragment
    lateinit var detailFragment: PhotoDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation(){
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

//        val bottomNavigation = findNavController(R.id.container)


//        bottomNav.setupWithNavController(bottomNavigation)

//        bottomNavigation.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id == R.id.photoDetailFragment){
//                bottomNav.visibility = View.GONE
//            }else{
//                bottomNav.visibility = View.VISIBLE
//            }
//        }


        bottomNav.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.collection -> {
                    collectionFragment = CollectionFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, collectionFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.account -> {
                    accountFragment = AccountFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, accountFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true

        }
    }
}