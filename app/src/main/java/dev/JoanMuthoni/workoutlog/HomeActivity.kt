package dev.JoanMuthoni.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var btnHome:BottomNavigationView
    lateinit var fcvhome:FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        castviews()
    }
        fun castviews() {
            btnHome = findViewById(R.id.bottom_navigation)
            fcvhome = findViewById(R.id.bottom_navigation)
        }

        fun setupBottomNav() {
            btnHome.setOnItemSelectedListener {item->
                when (item.itemId) {
                        R.id.page_1-> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.fcvhome, PlanFragment()).commit()
                            true
                        }
                        R.id.page_2->{
                            supportFragmentManager.beginTransaction().replace(R.id.fcvhome, TrackFragment()).commit()
                            true
                                                    }
                                R.id.page_3 ->{
                            supportFragmentManager.beginTransaction().replace(R.id.fcvhome, ProfileFragment()).commit()
                            true
                        }
                            else -> false
                        }
                    }
                }

        }
