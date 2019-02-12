package com.ksmartsolutions.swoosh

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skills.*

class SkillsActivity : BaseActivity() {

    var selectedLeague = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)
        selectedLeague = intent.getStringExtra(EXTRA_LEAGUE)

        ballerButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                selectedSkill = "baller"
                beginnerButton.isChecked = false
            }
        }

        beginnerButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                selectedSkill = "beginner"
                ballerButton.isChecked = false
            }
        }

        finishButton.setOnClickListener {
            if(!ballerButton.isChecked && !beginnerButton.isChecked) {
                Toast.makeText(this, "Please select your level", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "League: $selectedLeague, Skill: $selectedSkill", Toast.LENGTH_LONG).show()
            }
        }
    }
}
