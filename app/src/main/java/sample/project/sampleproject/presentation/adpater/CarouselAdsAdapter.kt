package sample.project.sampleproject.presentation.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.viewpager.widget.PagerAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import sample.project.sampleproject.R


class CarouselAdsAdapter(
    private val adsId : List<String> = listOf()
) :  PagerAdapter() {

    private var mAdView : AdView? = null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun getCount(): Int {
        return adsId.count()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(container.context)
                .inflate(
                    R.layout.carousel_ads_view,
                    container,
                    false
                )
        val root : ConstraintLayout = view.findViewById(R.id.root)
        val set = ConstraintSet()

        mAdView = AdView(container.context)

        val params: ConstraintLayout.LayoutParams =
            ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )

        mAdView?.apply {
            id = R.id.ads_View
            layoutParams = params
//            adSize = AdSize(400, 100)
            adSize = AdSize.BANNER
            adUnitId = adsId[position]
        }

        root.removeAllViews()
        root.addView(mAdView)
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        mAdView?.destroy()
        mAdView = null
        container.removeView(`object` as View)
    }
}
