package sample.project.sampleproject.presentation.ui.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.MobileAds
import sample.project.sampleproject.presentation.adpater.CarouselAdsAdapter
import sample.project.sampleproject.presentation.adpater.SampleDataAdapter
import sample.project.sampleproject.base.MVPLifecycleObserver
import sample.project.sampleproject.databinding.ActivityMainBinding
import sample.project.sampleproject.di.implementation.DependencyInjectorImpl
import sample.project.sampleproject.model.SampleData
import sample.project.sampleproject.util.autoScroll

class SampleActivity : AppCompatActivity() ,
    SampleView, SampleDataAdapter.Interaction {


    private val autoScrollTime = 15000L
    private val lazyPresenter by lazy {
        SamplePresenter(
            DependencyInjectorImpl()
        )
    }
    private lateinit var lifeCycleObserver: MVPLifecycleObserver<SampleView, SamplePresenter>

    private val sampleAdapter = SampleDataAdapter(this)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init Ad Mob
        MobileAds.initialize(this) {}

        binding.rvContent.adapter = sampleAdapter

        lifeCycleObserver = MVPLifecycleObserver(this, getPresenter())
         this.lifecycle.addObserver(lifeCycleObserver)
    }

    override fun getPresenter(): SamplePresenter = lazyPresenter

    override fun addSampleEntries(data: List<SampleData>) {
        sampleAdapter.submitList(data)
    }

    override fun addAdsView(data: List<String>) {
        binding.vpAds.adapter = null
        val carouselAdapter = CarouselAdsAdapter(data)
        binding.vpAds.adapter = carouselAdapter
        binding.vpAds.autoScroll(autoScrollTime)
        binding.vpAds.offscreenPageLimit = data.count()
        binding.tabLayout.setupWithViewPager(binding.vpAds, true)
    }

    override fun onItemSelected(position: Int, item: SampleData) {

    }
}

