package com.ksmartsolutions.swoosh.Controllers

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.ksmartsolutions.swoosh.Models.Player
import com.ksmartsolutions.swoosh.R
import com.ksmartsolutions.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState?.getParcelable(EXTRA_PLAYER) as Player
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        mensToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                player.league = "men"
                womensToggleButton.isChecked = false
                co_edToggleButton.isChecked = false
            }
        }

        womensToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                player.league = "women"
                mensToggleButton.isChecked = false
                co_edToggleButton.isChecked = false
            }
        }

        co_edToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                player.league = "co-ed"
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
                skillsIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(skillsIntent)
            }
        }
    }
}
