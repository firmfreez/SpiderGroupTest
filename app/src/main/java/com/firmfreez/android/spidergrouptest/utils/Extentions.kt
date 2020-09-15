package com.firmfreez.android.spidergrouptest.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

/**
 * Меняет фрагменты
 * @param resId - id действия замены из nav_graph.xml
 */
fun Fragment.navigate(resId: Int, bundle: Bundle? = null) {
    return NavHostFragment.findNavController(this).navigate(resId, bundle)
}

/**
 * Позволяет быстро превратить ID в ссылку на картинку
 */
fun String.toImgurUrl(big: Boolean): String {
    return if(big) {
        "https://i.imgur.com/$this.jpeg"
    } else {
        "https://i.imgur.com/$this.jpg"
    }
}