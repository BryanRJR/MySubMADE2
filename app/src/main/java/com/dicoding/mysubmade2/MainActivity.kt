package com.dicoding.mysubmade2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.dicoding.mysubmade2.databinding.ActivityMainBinding
import com.dicoding.mysubmade2.home.HomeFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var activityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        setSupportActionBar(activityBinding.barMain.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            activityBinding.dwrLayout,
            activityBinding.barMain.toolbar,
            R.string.nav_drawer_open,
            R.string.nav_close
        )
        activityBinding.dwrLayout.addDrawerListener(toggle)
        toggle.syncState()

        activityBinding.navigationView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_favorite -> {
                fragment = Class.forName("com.dicoding.favorite.FavoriteFragment").newInstance() as Fragment
                title = getString(R.string.fav_menu)
            }
            R.id.nav_about -> {
                fragment = About()
                title = getString(R.string.about_menu)
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        activityBinding.dwrLayout.closeDrawer(GravityCompat.START)
        return true
    }
}