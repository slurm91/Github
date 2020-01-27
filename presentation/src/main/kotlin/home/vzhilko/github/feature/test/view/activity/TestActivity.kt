package home.vzhilko.github.feature.test.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import home.vzhilko.github.R

class TestActivity : AppCompatActivity() {

    protected val navController: NavController by lazy {
        findNavController(R.id.activity_test_nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

}