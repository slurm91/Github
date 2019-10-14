package home.vzhilko.github.base.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import home.vzhilko.github.R
import home.vzhilko.github.extension.logDebug

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    protected val navController: NavController by lazy {
        findNavController(R.id.activity_base_nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        init()
    }

    private fun init() {
        findViews()
        //val appBarConfiguration = AppBarConfiguration(setOf(R.id.start_fragment, R.id.test_fragment), drawerLayout)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.start_fragment, R.id.test_list_fragment), drawerLayout)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller,
                                                        destination,
                                                        arguments ->
            when (destination.id) {
                R.id.start_fragment -> {
                    ("BaseActivity init destination.id = R.id.start_fragment: ${destination.id == R.id.start_fragment}" +
                            " navController.graph.id == R.id.main_graph: ${navController.graph.id == R.id.main_graph} ").logDebug()
                    toolbar.navigationIcon = null
                    /*val defaultAppBarConfiguration = AppBarConfiguration(navController.graph)
                    toolbar.setupWithNavController(navController, defaultAppBarConfiguration)*/
                }
                else -> {
                    /*("BaseActivity init destination.id = R.id.test_fragment: ${destination.id == R.id.test_fragment}" +
                            " navController.graph.id == R.id.auth_graph: ${navController.graph.id == R.id.auth_graph} ").logDebug()*/
                    ("BaseActivity init destination.id = R.id.test_fragment: ${destination.id == R.id.test_list_fragment}" +
                            " navController.graph.id == R.id.auth_graph: ${navController.graph.id == R.id.auth_graph} ").logDebug()
                    toolbar.navigationIcon = getDrawable(R.drawable.ic_toolbar_menu)
                    /*val drawerAppBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
                    toolbar.setupWithNavController(navController, drawerAppBarConfiguration)
                    navigationView.setupWithNavController(navController)*/
                }
            }
        }
    }

    private fun findViews() {
        toolbar = findViewById(R.id.activity_base_toolbar)
        drawerLayout = findViewById(R.id.activity_base_drawer_layout)
        navigationView = findViewById(R.id.activity_base_navigation_view)
    }

}