package com.kyawt.mycollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kyawt.mycollection.view.ui.SignUpFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation(){

        val navController = findNavController(R.id.container)

        bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.photoDetailFragment || destination.id == R.id.categoryFragment || destination.id == R.id.collectionFragment || destination.id == R.id.loginFragment || destination.id == R.id.loginDashboardFragment || destination.id == R.id.signUpFragment){
                bottomNav.visibility = View.GONE
            }else{
                bottomNav.visibility = View.VISIBLE
            }
        }

    }
}