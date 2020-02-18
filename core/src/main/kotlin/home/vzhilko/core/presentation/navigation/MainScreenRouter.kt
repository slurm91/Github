package home.vzhilko.core.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import home.vzhilko.core.R
import home.vzhilko.core.presentation.extension.createAndAddFragmentDestination

fun navigateToMainScreen(activity: FragmentActivity, navController: NavController) {
    val graph = navController.graph
    graph.createAndAddFragmentDestination(
        destinationId = R.id.id_navigation_screen_main,
        destinationClassName = activity.resources.getStringArray(R.array.array_screen_classname)[2],
        activity = activity
    )
    navController.navigate(R.id.id_navigation_screen_main)
}