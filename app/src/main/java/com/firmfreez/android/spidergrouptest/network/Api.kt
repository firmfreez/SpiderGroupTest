package com.firmfreez.android.spidergrouptest.network

import com.firmfreez.android.spidergrouptest.models.GalleryItems
import com.firmfreez.android.spidergrouptest.models.ImageComments
import com.firmfreez.android.spidergrouptest.models.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api {

    //Получение списка популярных фотографий
    @GET("gallery/top/viral/day/{page}?showViral=true&mature=true&album_previews=true")
    @Headers("Authorization: Client-ID $CLIENT_ID")
    suspend fun getGalleryItems(@Path(value = "page", encoded = true) page: Int) : Response<GalleryItems>

    //Получения списка комментариев конкретной фотографии
    @GET("https://api.imgur.com/3/gallery/{image_id}/comments/best")
    @Headers("Authorization: Client-ID ${Companion.CLIENT_ID}")
    suspend fun getCommentsList(@Path(value="image_id", encoded = true) imageId: String) : Response<ImageComments>

    //Получение информации об изображении
    @GET("https://api.imgur.com/3/gallery/{image_id}")
    @Headers("Authorization: Client-ID ${Companion.CLIENT_ID}")
    suspend fun getImageInfo(@Path(value="image_id", encoded = true) imageId: String) : Response<ImageResponse>

    companion object {
        const val BASE_URL      = "https://api.imgur.com/3/"
        const val CLIENT_SECRET = "eb9f26f2689c11a549cd3fe6b4991383a667a0d1"
        const val CLIENT_ID     = "2f293516ceaecd3"
    }
}