package com.firmfreez.android.spidergrouptest.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.firmfreez.android.spidergrouptest.di.App
import com.firmfreez.android.spidergrouptest.models.GalleryItems
import com.firmfreez.android.spidergrouptest.services.GalleryService
import com.firmfreez.android.spidergrouptest.ui.dataSources.GalleryImagesDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * ViewModel отвечает за загрузку данных для RecyclerView используя Flow
 */
class ImagesViewModel : ViewModel() {
    @Inject lateinit var galleryService: GalleryService

    init {
        App.instance.component?.inject(this)
    }

    //Получения списка изображений
    val movies: Flow<PagingData<GalleryItems.ImagesItem>> = Pager(PagingConfig(pageSize = 10)) {
        GalleryImagesDataSource(galleryService)
    }.flow.cachedIn(viewModelScope)
}