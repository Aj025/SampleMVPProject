package sample.project.sampleproject.presentation.ui.sample

import sample.project.sampleproject.base.BaseView
import sample.project.sampleproject.model.SampleData

interface SampleView : BaseView<SamplePresenter> {

    fun addSampleEntries(data: List<SampleData>)
    fun addAdsView(data: List<String>)
}
