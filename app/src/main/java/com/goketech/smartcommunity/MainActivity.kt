package com.goketech.smartcommunity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.goketech.smartcommunity.view.activity.ActivityFragment
import com.goketech.smartcommunity.view.main.MainFragment
import com.goketech.smartcommunity.view.my.My_Fragment
import com.goketech.smartcommunity.view.neighbourhood.NeighbourhoodFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainfragment : MainFragment?=null
    var neighbourhoodFragment : NeighbourhoodFragment?=null
    var activityFragment : ActivityFragment?=null
    var myFragment : My_Fragment?=null


    val beginTransaction = supportFragmentManager.beginTransaction()
    //private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { tm ->

        beginTransaction
        when (tm.itemId) {
            R.id.navigation_home -> {
                beginTransaction.replace(R.id.layout_page,mainfragment!!).commit()
                //textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                beginTransaction.replace(R.id.layout_page,neighbourhoodFragment!!).commit()
                //textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                beginTransaction.replace(R.id.layout_page,activityFragment!!).commit()
                //textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my -> {
                beginTransaction.replace(R.id.layout_page,myFragment!!).commit()
                //textMessage.setText(R.string.title_my)
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        initFragment()

    }

    fun initFragment(){
         mainfragment  = MainFragment()
         neighbourhoodFragment =  NeighbourhoodFragment()
         activityFragment =  ActivityFragment()
         myFragment =  My_Fragment()

        val beginTransaction1 = supportFragmentManager.beginTransaction()
        beginTransaction1.add(R.id.layout_page,mainfragment!!)
        beginTransaction1.add(R.id.layout_page,neighbourhoodFragment!!)
        beginTransaction1.add(R.id.layout_page,activityFragment!!)
        beginTransaction1.add(R.id.layout_page,myFragment!!)

        beginTransaction1.replace(R.id.layout_page,mainfragment!!).commit();
    }
}
