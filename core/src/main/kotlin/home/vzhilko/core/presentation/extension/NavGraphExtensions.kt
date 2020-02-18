package home.vzhilko.core.presentation.extension

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavGraph
import androidx.navigation.fragment.FragmentNavigator
import home.vzhilko.core.R

fun NavGraph.createAndAddFragmentDestination(
    destinationId: Int,
    destinationClassName: String,
    activity: FragmentActivity
) {
    addDestination(createFragmentDestination(destinationId, destinationClassName, activity))
}

fun NavGraph.createFragmentDestination(
    destinationId: Int,
    destinationClassName: String,
    activity: FragmentActivity
): FragmentNavigator.Destination {
    return FragmentNavigator(
        activity,
        activity.supportFragmentManager,
        R.id.id_fragment_container
    ).createDestination().apply {
        id = destinationId
        className = destinationClassName
        Log.d("myTag", "NavGraphExt id: ${id}")
    }
}