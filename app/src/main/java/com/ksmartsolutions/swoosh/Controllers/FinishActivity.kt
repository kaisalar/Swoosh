package com.ksmartsolutions.swoosh.Controllers

import android.os.Bundle
import com.ksmartsolutions.swoosh.Models.Player
import com.ksmartsolutions.swoosh.R
import com.ksmartsolutions.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra(EXTRA_PLAYER) as Player

        val result = "Looking for ${player.league} ${player.skill} league near you..."

        finalResultTextView.text = result
    }
}
