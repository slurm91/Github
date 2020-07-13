package home.vzhilko.core.presentation.view.activity

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import home.vzhilko.core.R
import home.vzhilko.core.databinding.ActivityAppBinding

class AppActivity : BaseActivity() {

    private val onToolbarBackButtonListener: View.OnClickListener = View.OnClickListener {
        onBackPressed()
    }

    private val onToolbarMenuButtonListener: View.OnClickListener = View.OnClickListener {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        val binding: ActivityAppBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_app)
        toolbar = binding.activityAppToolbar
        progressBar = binding.activityAppProgressbar
        drawerLayout = binding.activityAppDrawerLayout
        navigationView = binding.activityAppNavigationView
        initNavigation()
    }

    private fun initNavigation() {
        navController = findNavController(R.id.id_fragment_container)

        val graphId: Int = resources.getIdentifier("graph_app", "navigation", packageName)
        val graph: NavGraph = navController.navInflater.inflate(graphId)
        navController.graph = graph

        val appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.id_navigation_screen_welcome, R.id.id_navigation_screen_main),
                drawerLayout
            )

        toolbar.setupWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller,
                                                        destination,
                                                        arguments ->
            when (destination.id) {
                R.id.id_navigation_screen_welcome -> {
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
