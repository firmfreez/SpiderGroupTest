package com.firmfreez.android.spidergrouptest.network

import com.firmfreez.android.spidergrouptest.models.GalleryItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api {

    @GET("gallery/top/viral/day/{page}?showViral=true&mature=false&album_previews=false")
    @Headers("Authorization: Client-ID $CLIENT_ID")
    suspend fun getGalleryItems(@Path(value = "page", encoded = true) page: Int) : Response<GalleryItems>

    companion object {
        const val BASE_URL      = "https://api.imgur.com/3/"
        const val CLIENT_SECRET = "eb9f26f2689c11a549cd3fe6b4991383a667a0d1"
        const val CLIENT_ID     = "2f293516ceaecd3"
    }
}