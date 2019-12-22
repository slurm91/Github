package home.vzhilko.github.feature.test.viewmodel

import androidx.lifecycle.*
import home.vzhilko.github.App
import home.vzhilko.github.base.model.UserModel
import home.vzhilko.github.extension.logDebug
import javax.inject.Inject

class TestViewModel @Inject constructor(app: App) : AndroidViewModel(app) {

    var userModelLiveData = MutableLiveData<UserModel>()
    var loginLiveData: LiveData<String> = Transformations.map(userModelLiveData) { data ->
        data.login
    }

    var testMutableLiveData: LiveData<String> = MutableLiveData<String>()

    init {
        getUserModel()
        //testMutableLiveData.value = "test"
    }

    fun getUserModel() {
        userModelLiveData.value = UserModel("view model", "1234")
    }

    fun onChangedUserModel() {
        "TestViewModel onChangedUserModel login: ${loginLiveData.value}".logDebug()
        loginLiveData.value?.let {
            if (it == "view model") {
                userModelLiveData.value?.login = "view model 2"
                userModelLiveData.value = userModelLiveData.value
            } else {
                userModelLiveData.value?.login = "view model"
                userModelLiveData.value = userModelLiveData.value
            }
        }
    }

}