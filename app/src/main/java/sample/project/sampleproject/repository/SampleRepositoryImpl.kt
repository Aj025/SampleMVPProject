package sample.project.sampleproject.repository

import sample.project.sampleproject.R
import sample.project.sampleproject.model.SampleData

class SampleRepositoryImpl : SampleRepository {
    override fun getDummyList(): List<SampleData> {
        return mutableListOf(
            SampleData("2021-03-01T02:04:33Z", R.drawable.ic_money_24, "RECEIVED", 100),
            SampleData("2021-02-28T03:04:33Z", R.drawable.ic_money_24, "RECEIVED", 150),
            SampleData("2021-02-24T02:04:33Z", R.drawable.ic_monetization_on_24, "RECEIVED", 120),
            SampleData("2021-02-24T03:04:33Z", R.drawable.ic_monetization_on_24, "RECEIVED", 500),
            SampleData("2021-02-23T02:04:33Z", R.drawable.ic_money_off_24, "RECEIVED", 300),
            SampleData("2021-02-23T02:04:33Z", R.drawable.ic_money_off_24, "RECEIVED", 310),
            SampleData("2021-02-21T02:04:33Z", R.drawable.ic_money_off_24, "RECEIVED", 320)
        )

    }

    override fun getDummyAdsID(): List<String> {
        return  mutableListOf(
            "ca-app-pub-3940256099942544/6300978111",
            "ca-app-pub-3940256099942544/6300978111",
            "ca-app-pub-3940256099942544/6300978111"
        )
    }
}