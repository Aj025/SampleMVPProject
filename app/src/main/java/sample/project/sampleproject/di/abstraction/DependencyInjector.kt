package sample.project.sampleproject.di.abstraction

import sample.project.sampleproject.repository.SampleRepository

interface DependencyInjector {
    fun sampleRepository()  : SampleRepository
}