package sample.project.sampleproject.repository

import sample.project.sampleproject.model.SampleData

interface SampleRepository {
    fun getDummyList() : List<SampleData>
    fun getDummyAdsID() : List<String>
}