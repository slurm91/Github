package home.vzhilko.github.base.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import home.vzhilko.github.R
import home.vzhilko.github.base.view.component.progressbar.IProgressBar
import home.vzhilko.github.databinding.ActivityBaseBinding

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

    protected val navController: NavController by lazy {
        findNavController(R.id.activity_base_nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        val binding: ActivityBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        toolbar = binding.activityBaseToolbar
        progressBar = binding.activityBaseProgressbar
        drawerLayout = binding.activityBaseDrawerLayout
        navigationView = binding.activityBaseNavigationView
        initNavigation()
    }

    private fun initNavigation() {
        val appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.start_fragment, R.id.test_list_fragment, R.id.main_fragment),
                drawerLayout
            )
        toolbar.setupWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller,
                                                        destination,
                                                        arguments ->
            when (destination.id) {
                R.id.start_fragment -> {
                    toolbar.navigationIcon = null
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
                R.id.main_fragment -> {
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