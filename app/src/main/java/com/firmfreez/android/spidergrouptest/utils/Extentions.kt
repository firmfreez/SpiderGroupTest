package com.firmfreez.android.spidergrouptest.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

fun Fragment.navigate(resId: Int, bundle: Bundle? = null) {
    return NavHostFragment.findNavController(this).navigate(resId, bundle)
}