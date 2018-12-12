package com.nicholasdoglio.weather.testing

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.Nullable
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AppCompatActivity
import com.nicholasdoglio.weather.R

@RestrictTo(RestrictTo.Scope.TESTS)
class SingleFragmentActivity : AppCompatActivity() {
  override fun onCreate(@Nullable savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val content = FrameLayout(this)
    content.layoutParams = FrameLayout.LayoutParams(
      ViewGroup.LayoutParams.MATCH_PARENT,
      ViewGroup.LayoutParams.MATCH_PARENT
    )
    content.id = R.id.content_frame
    setContentView(content)
  }

  fun setFragment(fragment: androidx.fragment.app.Fragment) {
    supportFragmentManager.beginTransaction()
      .add(R.id.content_frame, fragment, "TEST")
      .commit()
  }

  fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
    supportFragmentManager.beginTransaction()
      .replace(R.id.content_frame, fragment).commit()
  }
}