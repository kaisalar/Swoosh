package com.ksmartsolutions.swoosh

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        mensToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                womensToggleButton.isChecked = false
                co_edToggleButton.isChecked = false
            }
        }

        womensToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                mensToggleButton.isChecked = false
                co_edToggleButton.isChecked = false
            }
        }

        co_edToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                mensToggleButton.isChecked = false
                womensToggleButton.isChecked = false
            }
        }

        nextButton.setOnClickListener {
            if(!mensToggleButton.isChecked && !womensToggleButton.isChecked && !co_edToggleButton.isChecked) {
                Toast.makeText(this, "Please select one league", Toast.LENGTH_LONG).show()
            } else {
                val skillsIntent = Intent(this, SkillsActivity::class.java)
                startActivity(skillsIntent)
            }
        }
    }
}
