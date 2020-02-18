package home.vzhilko.core.presentation.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.*
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import home.vzhilko.core.R
import home.vzhilko.core.base.extension.logDebug
import home.vzhilko.core.databinding.ActivityBaseBinding
import home.vzhilko.core.presentation.navigation.addStartScreenAsStartDestination
import home.vzhilko.core.presentation.view.progressbar.IProgressBar

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var progressBar: IProgressBar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    var isProgressShown: Boolean = false
        set(value) {
            field = value
            progressBar.apply { if (field) showProgress() else hideProgress() }
        }

    private val onToolbarBackButtonListener: View.OnClickListener = View.OnClickListener {
        onBackPressed()
    }

    private val onToolbarMenuButtonListener: View.OnClickListener = View.OnClickListener {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    val navController: NavController by lazy {
        findNavController(R.id.id_fragment_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        "core base activity: ".logDebug()
    }

    private fun init() {
        val binding: ActivityBaseBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_base)
        toolbar = binding.activityBaseToolbarCore
        progressBar = binding.activityBaseProgressbarCore
        drawerLayout = binding.activityBaseDrawerLayout
        navigationView = binding.activityBaseNavigationViewCore
        initNavigation()
    }

    private fun initNavigation() {
        addStartScreenAsStartDestination(this, navController)
        val appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.id_navigation_screen_start, R.id.id_navigation_screen_main),
                drawerLayout
            )
        toolbar.setupWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller,
                                                        destination,
                                                        arguments ->
            when (destination.id) {
                R.id.id_navigation_screen_start -> {
                    toolbar.navigationIcon = null
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
                R.id.id_navigation_screen_main -> {
                    toolbar.setNavigationOnClickListener(onToolbarMenuButtonListener)
                    toolbar.navigationIcon = getDrawable(R.drawable.ic_toolbar_menu)
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
                else -> {
                    toolbar.setNavigationOnClickListener(onToolbarBackButtonListener)
                    toolbar.navigationIcon = getDrawable(R.drawable.ic_toolbar_arrow)
                }
            }
        }
    }

}