package sample.project.sampleproject.presentation.ui.sample

import android.util.Log
import sample.project.sampleproject.base.BasePresenter
import sample.project.sampleproject.di.abstraction.DependencyInjector
import sample.project.sampleproject.repository.SampleRepository

class SamplePresenter(
    private val dependencyInjector: DependencyInjector
) : BasePresenter<SampleView>() {

    private val sampleRepository : SampleRepository =
        dependencyInjector.sampleRepository()

    override fun onViewAttached() {
        super.onViewAttached()
        Log.d(TAG, "$TAG attached")
        val data = sampleRepository.getDummyList()
        view?.addSampleEntries(data)
        val adsData = sampleRepository.getDummyAdsID()
        view?.addAdsView(adsData)
    }

    override fun onViewDetached() {
        super.onViewDetached()
        Log.d(TAG, "$TAG detached")
    }

    private companion object {
        const val TAG = "AdoptionListPresenter"
    }
}