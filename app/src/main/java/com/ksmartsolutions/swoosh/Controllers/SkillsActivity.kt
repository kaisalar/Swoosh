package com.ksmartsolutions.swoosh.Controllers

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.ksmartsolutions.swoosh.Models.Player
import com.ksmartsolutions.swoosh.R
import com.ksmartsolutions.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skills.*

class SkillsActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)
        player = intent.getParcelableExtra(EXTRA_PLAYER) as Player

        ballerButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                player.skill = "baller"
                beginnerButton.isChecked = false
            }
        }

        beginnerButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                player.skill = "beginner"
                ballerButton.isChecked = false
            }
        }

        finishButton.setOnClickListener {
            if(!ballerButton.isChecked && !beginnerButton.isChecked) {
                Toast.makeText(this, "Please select your level", Toast.LENGTH_LONG).show()
            } else {
                val finishIntent = Intent(this, FinishActivity::class.java)
                finishIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(finishIntent)
            }
        }

        backButton.setOnClickListener { onBackPressed() }
    }
}
