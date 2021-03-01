package sample.project.sampleproject.di.implementation

import sample.project.sampleproject.di.abstraction.DependencyInjector
import sample.project.sampleproject.repository.SampleRepository
import sample.project.sampleproject.repository.SampleRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {
    override fun sampleRepository(): SampleRepository  = SampleRepositoryImpl()
}