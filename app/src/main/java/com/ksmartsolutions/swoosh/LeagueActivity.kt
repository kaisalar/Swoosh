package com.ksmartsolutions.swoosh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        mensToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                selectedLeague = "men"
                womensToggleButton.isChecked = false
                co_edToggleButton.isChecked = false
            }
        }

        womensToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                selectedLeague = "women"
                mensToggleButton.isChecked = false
                co_edToggleButton.isChecked = false
            }
        }

        co_edToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                selectedLeague = "co-ed"
                mensToggleButton.isChecked = false
                womensToggleButton.isChecked = false
            }
        }

        nextButton.setOnClickListener {
            if(!mensToggleButton.isChecked && !womensToggleButton.isChecked && !co_edToggleButton.isChecked) {
                //Snackbar.make(it, "Please select one league", Snackbar.LENGTH_LONG).show()
                Toast.makeText(this, "Please select one league", Toast.LENGTH_LONG).show()
            } else {
                val skillsIntent = Intent(this, SkillsActivity::class.java)
                skillsIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
                startActivity(skillsIntent)
            }
        }
    }
}
