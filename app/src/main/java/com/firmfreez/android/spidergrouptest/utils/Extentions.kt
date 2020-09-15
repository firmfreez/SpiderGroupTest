package com.firmfreez.android.spidergrouptest.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

fun Fragment.navigate(resId: Int, bundle: Bundle? = null) {
    return NavHostFragment.findNavController(this).navigate(resId, bundle)
}

fun String.toImgurUrl(big: Boolean): String {
    return if(big) {
        "https://i.imgur.com/$this.jpeg"
    } else {
        "https://i.imgur.com/$this.jpg"
    }
}