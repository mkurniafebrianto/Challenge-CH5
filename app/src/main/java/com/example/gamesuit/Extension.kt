package com.example.gamesuit

import android.content.Context
import android.content.Intent

fun Context.intentTo(clazz: Class<*>, beforeStart: (Intent) -> Unit) {
    val intent = Intent(this, clazz)
    beforeStart.invoke(intent)
    startActivity(intent)
}