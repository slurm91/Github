package home.vzhilko.core.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.FragmentNavigator
import home.vzhilko.core.R
import home.vzhilko.core.presentation.extension.createAndAddFragmentDestination
import home.vzhilko.core.presentation.extension.createFragmentDestination

fun addStartScreenAsStartDestination(activity: FragmentActivity, navController: NavController) {
    val graph = navController.navInflater.inflate(R.navigation.app_graph)
    graph.apply {
        graph.addDestination(createStartScreenDestination(activity, graph))
        startDestination = R.id.id_navigation_screen_welcome
    }
    navController.graph = graph
}

fun navigateToStartScreen(activity: FragmentActivity, navController: NavController) {
    val graph = navController.navInflater.inflate(R.navigation.app_graph)
    graph.addDestination(createStartScreenDestination(activity, graph))
    navController.navigate(R.id.id_navigation_screen_welcome)
}

private fun createStartScreenDestination(
    activity: FragmentActivity,
    graph: NavGraph
): FragmentNavigator.Destination {
    return graph.createFragmentDestination(
        destinationId = R.id.id_navigation_screen_welcome,
        destinationClassName = activity.resources.getStringArray(R.array.array_screen_classname)[0],
        activity = activity
    )
}