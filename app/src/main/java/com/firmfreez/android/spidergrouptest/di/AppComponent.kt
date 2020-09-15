package com.firmfreez.android.spidergrouptest.di

import com.firmfreez.android.spidergrouptest.ui.viewModels.ImagesViewModel
import com.firmfreez.android.spidergrouptest.ui.viewModels.SelectedImageViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AndroidModule::class])
@Singleton
interface AppComponent {

    //ViewModels
    fun inject(imagesViewModel: ImagesViewModel)
    fun inject(imagesViewModel: SelectedImageViewModel)
}