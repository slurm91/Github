package home.vzhilko.github.base.view.component.progressbar

import androidx.databinding.BindingAdapter

@BindingAdapter("isProgressShown")
fun setProgressBarVisibility(progressBar: RegularCircularProgressBar, showProgress: Boolean) {
    progressBar.apply { if (showProgress) showProgress() else hideProgress() }
}