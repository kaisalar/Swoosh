package com.ksmartsolutions.swoosh.Controllers

import android.os.Bundle
import com.ksmartsolutions.swoosh.R
import com.ksmartsolutions.swoosh.Utilities.EXTRA_LEAGUE
import com.ksmartsolutions.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        val result = "Looking for $league $skill league near you..."

        finalResultTextView.text = result
    }
}
