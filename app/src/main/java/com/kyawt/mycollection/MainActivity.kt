package com.kyawt.mycollection

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setupNavigation()
        setupNavigation()
    }


    private fun setupNavigation() {

        val navController = findNavController(R.id.container)

        bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.photoDetailFragment || destination.id == R.id.collectionItemsFragment || destination.id == R.id.collectionDetailFragment || destination.id == R.id.userFragment || destination.id == R.id.userPhotosDetailFragment || destination.id == R.id.likedDetailFragment || destination.id == R.id.usersCollectionsItemFragment) {
                bottomNav.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
            }
        }

    }
}