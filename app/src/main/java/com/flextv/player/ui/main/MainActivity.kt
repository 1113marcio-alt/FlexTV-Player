package com.flextv.player.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.flextv.player.R

/**
 * Activity principal que hospeda o fragmento de navegação da Leanback.
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}
