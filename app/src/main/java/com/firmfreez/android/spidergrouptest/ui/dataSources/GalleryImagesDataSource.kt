package com.firmfreez.android.spidergrouptest.ui.dataSources

import androidx.paging.PagingSource
import com.firmfreez.android.spidergrouptest.models.GalleryItems
import com.firmfreez.android.spidergrouptest.services.GalleryService
import java.lang.Exception
import java.lang.NullPointerException


/**
 * Используется для пагинации
 * Постранично загружает данные по мере необходимости
 */
class GalleryImagesDataSource (val galleryService: GalleryService): PagingSource<Int, GalleryItems.ImagesItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GalleryItems.ImagesItem> {
        try {
            val nextPage = params.key?: 1
            val response = galleryService.getGalleryItemsOrNull(nextPage)

            val resultData = response?.imageList
            return if(!resultData.isNullOrEmpty()) {
                LoadResult.Page(
                    data = resultData,
                    prevKey = if(nextPage == 0) null else nextPage - 1,
                    nextKey = nextPage + 1
                )
            } else {
                LoadResult.Error(NullPointerException())
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}