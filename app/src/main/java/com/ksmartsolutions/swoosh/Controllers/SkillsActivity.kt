package com.ksmartsolutions.swoosh.Controllers

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.ksmartsolutions.swoosh.R
import com.ksmartsolutions.swoosh.Utilities.EXTRA_LEAGUE
import com.ksmartsolutions.swoosh.Utilities.EXTRA_SKILL
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
                val finishIntent = Intent(this, FinishActivity::class.java)
                finishIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
                finishIntent.putExtra(EXTRA_SKILL, selectedSkill)
                startActivity(finishIntent)
            }
        }
    }
}
