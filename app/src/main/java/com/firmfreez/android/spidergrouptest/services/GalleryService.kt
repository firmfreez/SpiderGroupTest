package com.firmfreez.android.spidergrouptest.services

import com.firmfreez.android.spidergrouptest.models.GalleryItems
import com.firmfreez.android.spidergrouptest.models.ImageComments
import com.firmfreez.android.spidergrouptest.models.ImageResponse
import java.lang.Exception
import javax.inject.Inject

/**
 * Используется во ViewModels:
 * ImagesViewModel
 * SelectedImageViewModel, а так же в GalleryImageDataSource
 */
class GalleryService @Inject constructor() : ApiService() {

    /**
     * Получает список комментариев или null
     * @param id - ID изображения
     * @return ImageComments - data-class  / null
     */
    suspend fun getCommentsOrNull(id: String) : ImageComments? {
        return try {
            getComments(id)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Получает список комметариев
     * @param id - ID изображения
     * @return ImageComments - data-class
     */
    private suspend fun getComments(id: String) : ImageComments {
        return execute { api.getCommentsList(id) }
    }

    /**
     * Получает информацию об изображении или null
     * @param id - ID изображения
     * @return ImageResponse - data-class  / null
     */
    suspend fun getImageInfoOrNull(id: String) : ImageResponse? {
        return try {
            getImageInfo(id)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Получает информацию об изображении
     * @param id - ID изображения
     * @return ImageResponse - data-class
     */
    private suspend fun getImageInfo(id: String) : ImageResponse {
        return execute { api.getImageInfo(id) }
    }

    /**
     * Загружает список популярных фотографий или null
     * @param page - номер страницы
     * @return GalleryItems - data-class / null
     */
    suspend fun getGalleryItemsOrNull(page: Int) : GalleryItems? {
        return try {
            val data = getGalleryItems(page)
            if(data.data.isNullOrEmpty()) {
                null
            } else {
                data
            }
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Загружает список популярных фотографий
     * @param page - номер страницы
     * @return GalleryItems - data-class
     */
    private suspend fun getGalleryItems(page: Int) : GalleryItems {
        return execute { api.getGalleryItems(page) }
    }
}