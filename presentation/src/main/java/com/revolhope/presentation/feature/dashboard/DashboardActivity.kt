package com.revolhope.presentation.feature.dashboard

import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.revolhope.presentation.R
import com.revolhope.presentation.common.base.BaseActivity
import com.revolhope.presentation.databinding.ActivityDashboardBinding

class DashboardActivity : BaseActivity<ActivityDashboardBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override val binding: ActivityDashboardBinding
        get() = ActivityDashboardBinding.inflate(layoutInflater)

    override fun onBindViews() {
        super.onBindViews()
        setSupportActionBar(binding.contentLayout.toolbar)
        findNavController(binding.contentLayout.navHostContent.id).run {
            setupActionBarWithNavController(
                navController = this,
                configuration = AppBarConfiguration(
                    topLevelDestinationIds = setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow),
                    drawerLayout = binding.drawerLayout
                ).also { appBarConfiguration = it }
            )
            binding.navView.setupWithNavController(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.dashboard, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(binding.contentLayout.navHostContent.id).navigateUp(
            appBarConfiguration
        ) || super.onSupportNavigateUp()
}