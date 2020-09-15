package com.firmfreez.android.spidergrouptest.services

import com.firmfreez.android.spidergrouptest.models.GalleryItems
import java.lang.Exception
import javax.inject.Inject

class GalleryService @Inject constructor() : ApiService() {

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

    suspend fun getGalleryItems(page: Int) : GalleryItems {
        return execute { api.getGalleryItems(page) }
    }
}