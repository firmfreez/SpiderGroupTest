package com.firmfreez.android.spidergrouptest.services

import com.firmfreez.android.spidergrouptest.models.GalleryItems
import com.firmfreez.android.spidergrouptest.models.ImageComments
import com.firmfreez.android.spidergrouptest.models.ImageResponse
import java.lang.Exception
import javax.inject.Inject

class GalleryService @Inject constructor() : ApiService() {

    suspend fun getCommentsOrNull(id: String) : ImageComments? {
        return try {
            getComments(id)
        } catch (e: Exception) {
            null
        }
    }

    private suspend fun getComments(id: String) : ImageComments {
        return execute { api.getCommentsList(id) }
    }

    suspend fun getImageInfoOrNull(id: String) : ImageResponse? {
        return try {
            getImageInfo(id)
        } catch (e: Exception) {
            null
        }
    }

    private suspend fun getImageInfo(id: String) : ImageResponse {
        return execute { api.getImageInfo(id) }
    }

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

    private suspend fun getGalleryItems(page: Int) : GalleryItems {
        return execute { api.getGalleryItems(page) }
    }
}