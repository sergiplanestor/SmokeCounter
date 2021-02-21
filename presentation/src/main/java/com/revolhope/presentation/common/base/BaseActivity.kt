package com.revolhope.presentation.common.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.revolhope.presentation.R

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    enum class Navigation {
        MODAL,
        LATERAL
    }

    companion object {
        const val EXTRA_NAVIGATION = "extra.base.navigation"
    }

    abstract val binding: T

    private var isFirstOnResume = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onBindViews()
        onStartObservers()
    }

    override fun onResume() {
        super.onResume()
        if (isFirstOnResume) {
            onLoadData()
            isFirstOnResume = false
        } else {
            onReloadData()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        checkNavigationTransition(intent)
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        checkNavigationTransition(intent)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int, options: Bundle?) {
        super.startActivityForResult(intent, requestCode, options)
    }

    open fun onBindViews() {
        // Nothing to do here
    }

    open fun onStartObservers() {
        // Nothing to do here
    }

    open fun onLoadData() {
        // Nothing to do here
    }

    open fun onReloadData() {
        // Nothing to do here
    }

    private fun checkNavigationTransition(intent: Intent?) {
        intent?.takeIf { it.hasExtra(EXTRA_NAVIGATION) }?.let {
            overrideTransition(
                navigation = it.extras!!.getSerializable(EXTRA_NAVIGATION) as Navigation,
                isBack = false
            )
        }
    }

    private fun overrideTransition(navigation: Navigation, isBack: Boolean) {
        val transitions = when (navigation) {
            Navigation.MODAL -> {
                if (isBack) {

                } else {

                }
                0 to 0
            }
            Navigation.LATERAL -> {
                if (isBack) {

                } else {

                }
                0 to 0
            }
        }
        overridePendingTransition(transitions.first, transitions.second)
    }

    private fun getNavAnimations(intent: Intent?, isStart: Boolean = true): Pair<Int, Int> {
        val bundle = intent?.extras
        return when (val nav = (bundle?.getSerializable(EXTRA_NAVIGATION) as Navigation?)) {
            Navigation.LATERAL ->
                if (isStart) {
                    // TODO: Remove below, not necessary (check before)
                    // bundle?.putSerializable(EXTRA_NAVIGATION, Navigation.LATERAL)
                    Pair(R.anim.slide_in_right, R.anim.slide_out_left)
                } else {
                    Pair(R.anim.slide_in_left, R.anim.slide_out_right)
                }
            Navigation.MODAL ->
                if (isStart) {
                    // TODO: Remove below, not necessary (check before)
                    // bundle?.putSerializable(EXTRA_NAVIGATION, Navigation.MODAL)
                    Pair(R.anim.slide_in_up, android.R.anim.fade_out)
                } else {
                    Pair(android.R.anim.fade_in, R.anim.slide_out_down)
                }
            else -> Pair(0, 0)
        }
    }

    private fun overrideTransition() {
        val anim = getNavAnimations(intent, isStart = false)
        overridePendingTransition(anim.first, anim.second)
    }

}