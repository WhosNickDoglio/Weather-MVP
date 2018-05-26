package com.nicholasdoglio.weather.util

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Removes some boilerplate with inflating views
 * Used in onCreateView() methods in fragments and onCreateViewHolder() methods in adapters
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

/* Cleans up ugly toast calls */
fun Context.toast(message: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, this.getString(message), length).show()
    //TODO when ktx goes stable use that
}