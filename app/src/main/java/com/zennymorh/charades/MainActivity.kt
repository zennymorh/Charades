package com.zennymorh.charades

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.get
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.zennymorh.charades.databinding.ActivityMainBinding
import com.zennymorh.charades.scoreFragments.ScoreFragment
import com.zennymorh.charades.scoreFragments.ScoreFragmentArgs
import kotlinx.android.synthetic.main.score_fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Get the NavController for your NavHostFragment
        val navController = findNavController(R.id.myNavHost)

        // Set up the ActionBar to stay in sync with the NavController
        setupActionBarWithNavController(this, navController)

        appBarConfiguration = AppBarConfiguration.Builder(navController.graph)
            .build()


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHost)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
