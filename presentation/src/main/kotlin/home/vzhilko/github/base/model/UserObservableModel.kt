package home.vzhilko.github.base.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import home.vzhilko.github.BR

class UserObservableModel(
    login: String,
    password: String
) : BaseObservable() {

    @get:Bindable
    var login: String = login
    set(value) {
        field = value
        notifyPropertyChanged(BR.login)
    }

    @get:Bindable
    var password: String = password
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }

}