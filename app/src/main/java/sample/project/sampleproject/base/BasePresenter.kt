package sample.project.sampleproject.base

import androidx.annotation.CallSuper

abstract class BasePresenter<VIEW> : PresenterContract<VIEW> {
    protected var view : VIEW? = null

    override fun attach(view: VIEW) {
        this.view = view
        onViewAttached()
    }

    override fun detach() {
        view = null
        onViewDetached()
    }

    @CallSuper
    override fun onViewAttached() { /* do nothing */ }

    @CallSuper
    override fun onViewDetached() { /* do nothing */ }
}