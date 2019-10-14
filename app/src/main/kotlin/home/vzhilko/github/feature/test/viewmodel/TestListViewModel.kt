package home.vzhilko.github.feature.test.viewmodel

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import home.vzhilko.github.App
import home.vzhilko.github.feature.test.model.TestListItemModel
import home.vzhilko.github.feature.test.model.TestUserModel
import javax.inject.Inject

class TestListViewModel @Inject constructor(app: App) : AndroidViewModel(app) {

    var nameLiveData: MutableLiveData<String?> = MutableLiveData()
    var surnameLiveData: MutableLiveData<String?> = MutableLiveData()

    var testUserLiveData: MutableLiveData<TestUserModel?> = MutableLiveData()

    var testUserModel: TestUserModel? = null

    init {
        if (testUserModel == null) {
            testUserModel = TestUserModel("Ivan", "Ivanov")
        }

        if (nameLiveData.value == null) {
            nameLiveData.value = "Ivan"
        }

        if (surnameLiveData.value == null) {
            surnameLiveData.value = "Ivanov"
        }
    }

    fun changeName(name: CharSequence?) {
        Log.d(
            "myTag", "TestListViewModel changeName name: $name" +
                    " testUserModel.name: ${testUserModel?.name}"
        )
        testUserModel?.name = name?.toString()
        nameLiveData.value = name?.toString()
    }

    fun changeSurname(surname: CharSequence?) {
        testUserModel?.surname = surname?.toString()
        surnameLiveData.value = surname?.toString()
    }

    //region Data for list
    var testListLiveData: MutableLiveData<List<TestListItemModel>?> = MutableLiveData()

    fun updateList() {
        if (testListLiveData.value == null) {
            val list: MutableList<TestListItemModel> = mutableListOf()
            list.add(TestListItemModel("title1", "description1", false))
            list.add(TestListItemModel("title2", "description2", false))
            list.add(TestListItemModel("title3", "description3", false))
            list.add(TestListItemModel("title4", "description4", false))
            list.add(TestListItemModel("title5", "description5", false))
            list.add(TestListItemModel("title6", "description6", false))
            list.add(TestListItemModel("title7", "description7", false))
            list.add(TestListItemModel("title8", "description8", false))
            list.add(TestListItemModel("title9", "description19", false))
            list.add(TestListItemModel("title10", "description10", false))
            testListLiveData.value = list
        } else {
            testListLiveData.value = testListLiveData.value
        }
    }
    //endregion

}