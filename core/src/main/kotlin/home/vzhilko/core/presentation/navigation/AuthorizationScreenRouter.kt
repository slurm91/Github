package home.vzhilko.core.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import home.vzhilko.core.R
import home.vzhilko.core.presentation.extension.createAndAddFragmentDestination

fun navigateToAuthorizationScreen(activity: FragmentActivity, navController: NavController) {
    val graph = navController.graph
    graph.createAndAddFragmentDestination(
        destinationId = R.id.id_navigation_screen_auth,
        destinationClassName = activity.resources.getStringArray(R.array.array_screen_classname)[1],
        activity = activity
    )
    navController.navigate(R.id.id_navigation_screen_auth)
}