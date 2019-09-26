package com.example.jetpack_component.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.jetpack_component.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)
        val navController = Navigation.findNavController(this, R.id.nav_host_frag)
        setupBottomNav(navController)
        setUpsideNav(navController)
        setUpActionBar(navController)


    }

    private fun setUpActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this,navController,drawerlayout)
    }

    private fun setUpsideNav(navController: NavController) {
        nav_bottom?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun setupBottomNav(navController: NavController) {
        side_nav?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_frag),drawerlayout)
    }
}
