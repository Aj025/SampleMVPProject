package sample.project.sampleproject.util

import android.os.Handler
import android.os.Looper
import android.text.format.DateUtils
import androidx.viewpager.widget.ViewPager
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun ViewPager.autoScroll(interval : Long) {

    val mHandler =  Handler(Looper.getMainLooper())
    var scrollPosition = 0
    val runnable = object : Runnable {
        override fun run() {
            val count = adapter?.count ?: 0
            scrollPosition = currentItem
            if (count > 1) {
                setCurrentItem(scrollPosition++ % count, true)  
                mHandler.postDelayed(this, interval)
            } else {
                mHandler.removeCallbacks(this)
            }
        }
    }
    mHandler.post(runnable)
}


fun String.parseDate() : String {
    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val output = SimpleDateFormat("MMMM dd',' yyyy")

    var d: Date?
    try {
        d = input.parse(this)
    } catch (e : ParseException) {
//        return "Error can't convert the date"
        return e.message.toString()
    }
    if (d.isYesterday())
        return "Yesterday"
    if (d.isToday())
        return "Today"

    return output.format(d)
}

fun Date.isYesterday() : Boolean {
    return DateUtils.isToday(this.time + DateUtils.DAY_IN_MILLIS)
}

fun Date.isToday() : Boolean {
    return DateUtils.isToday(this.time )
}