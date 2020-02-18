package home.vzhilko.core.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import home.vzhilko.core.R
import home.vzhilko.core.presentation.extension.createAndAddFragmentDestination

fun addStartScreenAsStartDestination(activity: FragmentActivity, navController: NavController) {
    val graph = navController.navInflater.inflate(R.navigation.app_graph)
    graph.apply {
        createAndAddFragmentDestination(
            destinationId = R.id.id_navigation_screen_start,
            destinationClassName = activity.resources.getStringArray(R.array.array_screen_classname)[0],
            activity = activity
        )
        startDestination = R.id.id_navigation_screen_start
    }
    navController.graph = graph
}

fun navigateToStartScreen(activity: FragmentActivity, navController: NavController) {
    val graph = navController.navInflater.inflate(R.navigation.app_graph)
    graph.createAndAddFragmentDestination(
        destinationId = R.id.id_navigation_screen_start,
        destinationClassName = activity.resources.getStringArray(R.array.array_screen_classname)[0],
        activity = activity
    )
    navController.navigate(R.id.id_navigation_screen_start)
}