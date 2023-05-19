package com.example.npseiapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.NavigationUI
import com.example.npseiapp.ebook.EbookActivity

import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navController: NavController

    lateinit var drawerLayout: DrawerLayout
    private var toggle: ActionBarDrawerToggle? = null
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        navController = findNavController(this, R.id.frame_layout)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigation_view)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close)
        drawerLayout.addDrawerListener(toggle!!)
        toggle!!.syncState()
        Objects.requireNonNull(supportActionBar)!!.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener(this)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle?.onOptionsItemSelected(item) == true) {
            true
        } else true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_developer -> startActivity(Intent(this, Developer::class.java))
            R.id.navigation_eLibrary -> startActivity(Intent(this, ELibrary::class.java))
            R.id.navigation_share -> {
                val url =
                    "https://drive.google.com/drive/folders/1_v38GrmBvaxXXV-_Rmf48WGM8MsnMyZ9?usp=sharing"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
            R.id.navigation_prevPaper -> startActivity(Intent(this, EbookActivity::class.java))
//            R.id.navigation_results -> startActivity(Intent(this, Results::class.java))
            R.id.navigation_website -> startActivity(Intent(this, Website::class.java))
        }
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else super.onBackPressed()
    }
}