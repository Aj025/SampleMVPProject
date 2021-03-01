package sample.project.sampleproject.base

interface PresenterContract<VIEW> {
    fun attach(view : VIEW)
    fun detach()
    fun onViewAttached()
    fun onViewDetached()
}