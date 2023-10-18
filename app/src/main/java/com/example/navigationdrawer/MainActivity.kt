package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var imageMenu: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_View)
        imageMenu = findViewById(R.id.imageMenu)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Drawer item click event
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mHome -> {
                    Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawers()
                }
                R.id.mShare -> {
                    Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawers()
                }
            }
            false
        }

        // App Bar Click Event
        imageMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}
