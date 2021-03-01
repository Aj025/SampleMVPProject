package sample.project.sampleproject.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MVPLifecycleObserver<VIEW : BaseView<PRESENTER>, PRESENTER : BasePresenter<VIEW>>(
        private val view: VIEW,
        private val presenter: PRESENTER
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        presenter.attach(view)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        presenter.detach()
    }

}