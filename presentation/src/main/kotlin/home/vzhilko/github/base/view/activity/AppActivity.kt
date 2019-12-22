package home.vzhilko.github.base.view.activity

import android.os.Bundle
import home.vzhilko.github.base.model.UserModel
import home.vzhilko.github.extension.logDebug
import javax.inject.Inject
import javax.inject.Named

class AppActivity : DaggerBaseActivity() {

    @Inject
    @field: Named("AppActivity") lateinit var user: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //"AppActivity user ref $user".logDebug()
    }

}
