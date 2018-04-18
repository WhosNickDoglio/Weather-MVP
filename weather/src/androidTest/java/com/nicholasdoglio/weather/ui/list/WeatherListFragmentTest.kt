package com.nicholasdoglio.weather.ui.list

import android.support.test.rule.ActivityTestRule
import com.nicholasdoglio.weather.testing.SingleFragmentActivity
import org.junit.Before
import org.junit.Rule

class WeatherListFragmentTest {

    @Rule
    @JvmField
    val testActivityRule =
        ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    @Before
    fun setUp() {
        testActivityRule.activity.setFragment(WeatherListFragment())
    }
}