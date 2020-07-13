package home.vzhilko.core.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.*
import com.google.android.material.navigation.NavigationView
import home.vzhilko.core.presentation.view.progressbar.IProgressBar

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var toolbar: Toolbar
    protected lateinit var progressBar: IProgressBar
    protected lateinit var drawerLayout: DrawerLayout
    protected lateinit var navigationView: NavigationView

    lateinit var navController: NavController

    var isProgressShown: Boolean = false
        set(value) {
            field = value
            progressBar.apply { if (field) showProgress() else hideProgress() }
        }

}