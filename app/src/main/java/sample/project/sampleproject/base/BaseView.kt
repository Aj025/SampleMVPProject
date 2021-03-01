package sample.project.sampleproject.base

interface BaseView<PRESENTER> {
    fun getPresenter() : PRESENTER
}