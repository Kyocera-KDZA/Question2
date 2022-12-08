package com.itada.question2

import android.app.Notification.Action
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawer: DrawerLayout
    lateinit var navController: NavController
    lateinit var appConfigBar: AppBarConfiguration
   private lateinit var nav : NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //toolBar = findViewById(R.id.toolbar)
       // setSupportActionBar(toolBar)

        drawer  = findViewById(R.id.drawerLayout)
        nav = findViewById(R.id.nav_view)
       // navController = findViewById(R.id.content_frame)

        toggle = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
        drawer.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav.setNavigationItemSelectedListener {

            drawer.closeDrawer(GravityCompat.START)


            it.isChecked = true
            when(it.itemId){

                R.id.nav_home -> replaceFrag(HomeFragment(), it.title.toString())
                R.id.nav_frag1 -> replaceFrag(FirstFragment(), it.title.toString())
                R.id.nav_frag2 -> replaceFrag(SecondFragment(), it.title.toString())
                R.id.nav_frag3 -> replaceFrag(ThirdFragment(), it.title.toString())

            }

            true
        }

    }

    fun replaceFrag(frag: Fragment, title: String)
    {
        val fragManager = supportFragmentManager
        val fragTrans = fragManager.beginTransaction()
        fragTrans.replace(R.id.content_frame, frag)
        setTitle(title)
        fragTrans.commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}