package home.vzhilko.github.feature.test.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import home.vzhilko.github.BR

class TestUserModel(name: String, surname: String) : BaseObservable() {

    @get:Bindable
    var name: String? = name
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var surname: String? = surname
        set(value) {
            field = value
            notifyPropertyChanged(BR.surname)
        }

}