package com.becker.aston_hw_5_3_navigation_cicerone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by lazy { App.instance.getNavigatorHolder() }
    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = AppNavigator(this, R.id.main_fragment_container)
        val destination = FragmentA().getFragmentScreen()
        App.instance.getRouter().navigateTo(destination)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}