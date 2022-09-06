package dev.JoanMuthoni.workoutlog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.JoanMuthoni.workoutlog.R
import dev.JoanMuthoni.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
   lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castviews()
        setupBottomNav()
    }
        fun castviews() {

        }

        fun setupBottomNav() {
            binding.bottomNavigation.setOnItemSelectedListener {item->
                when (item.itemId) {
                        R.id.page_1 -> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.fcvhome, PlanFragment()).commit()
                            true
                        }
                        R.id.page_2 ->{
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
