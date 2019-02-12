package com.ksmartsolutions.swoosh

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skills.*

class SkillsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        ballerButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                beginnerButton.isChecked = false
            }
        }

        beginnerButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                ballerButton.isChecked = false
            }
        }

        finishButton.setOnClickListener {
            if(!ballerButton.isChecked && !beginnerButton.isChecked) {
                Toast.makeText(this, "Please select your level", Toast.LENGTH_LONG).show()
            } else {
                //some code
            }
        }
    }
}
