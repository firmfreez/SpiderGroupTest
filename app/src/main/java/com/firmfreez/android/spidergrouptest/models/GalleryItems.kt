package com.firmfreez.android.spidergrouptest.models

import android.media.Image
import com.google.gson.annotations.SerializedName

data class GalleryItems(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
{
	data class AdConfig(

		@field:SerializedName("showsAds")
		val showsAds: Boolean? = null,

		@field:SerializedName("unsafeFlags")
		val unsafeFlags: List<Any?>? = null,

		@field:SerializedName("wallUnsafeFlags")
		val wallUnsafeFlags: List<Any?>? = null,

		@field:SerializedName("safeFlags")
		val safeFlags: List<String?>? = null,

		@field:SerializedName("highRiskFlags")
		val highRiskFlags: List<Any?>? = null
	)

	data class DataItem(

		@field:SerializedName("comment_count")
		val commentCount: Int? = null,

		@field:SerializedName("in_most_viral")
		val inMostViral: Boolean? = null,

		@field:SerializedName("ad_type")
		val adType: Int? = null,

		@field:SerializedName("link")
		val link: String? = null,

		@field:SerializedName("description")
		val description: String? = null,

		@field:SerializedName("privacy")
		val privacy: String? = null,

		@field:SerializedName("section")
		val section: String? = null,

		@field:SerializedName("cover_height")
		val coverHeight: Int? = null,

		@field:SerializedName("title")
		val title: String? = null,

		@field:SerializedName("ad_config")
		val adConfig: AdConfig? = null,

		@field:SerializedName("points")
		val points: Int? = null,

		@field:SerializedName("cover")
		val cover: String? = null,

		@field:SerializedName("score")
		val score: Int? = null,

		@field:SerializedName("datetime")
		val datetime: Int? = null,

		@field:SerializedName("favorite_count")
		val favoriteCount: Int? = null,

		@field:SerializedName("id")
		val id: String? = null,

		@field:SerializedName("topic_id")
		val topicId: Int? = null,

		@field:SerializedName("in_gallery")
		val inGallery: Boolean? = null,

		@field:SerializedName("vote")
		val vote: Any? = null,

		@field:SerializedName("views")
		val views: Int? = null,

		@field:SerializedName("include_album_ads")
		val includeAlbumAds: Boolean? = null,

		@field:SerializedName("images")
		val images: List<ImagesItem?>? = null,

		@field:SerializedName("downs")
		val downs: Int? = null,

		@field:SerializedName("nsfw")
		val nsfw: Boolean? = null,

		@field:SerializedName("is_ad")
		val isAd: Boolean? = null,

		@field:SerializedName("ad_url")
		val adUrl: String? = null,

		@field:SerializedName("images_count")
		val imagesCount: Int? = null,

		@field:SerializedName("tags")
		val tags: List<TagsItem?>? = null,

		@field:SerializedName("layout")
		val layout: String? = null,

		@field:SerializedName("account_id")
		val accountId: Int? = null,

		@field:SerializedName("cover_width")
		val coverWidth: Int? = null,

		@field:SerializedName("is_album")
		val isAlbum: Boolean? = null,

		@field:SerializedName("account_url")
		val accountUrl: String? = null,

		@field:SerializedName("ups")
		val ups: Int? = null,

		@field:SerializedName("topic")
		val topic: String? = null,

		@field:SerializedName("favorite")
		val favorite: Boolean? = null,

		@field:SerializedName("gifv")
		val gifv: String? = null,

		@field:SerializedName("mp4_size")
		val mp4Size: Int? = null,

		@field:SerializedName("type")
		val type: String? = null,

		@field:SerializedName("has_sound")
		val hasSound: Boolean? = null,

		@field:SerializedName("height")
		val height: Int? = null,

		@field:SerializedName("bandwidth")
		val bandwidth: Long? = null,

		@field:SerializedName("edited")
		val edited: Int? = null,

		@field:SerializedName("looping")
		val looping: Boolean? = null,

		@field:SerializedName("hls")
		val hls: String? = null,

		@field:SerializedName("mp4")
		val mp4: String? = null,

		@field:SerializedName("size")
		val size: Int? = null,

		@field:SerializedName("width")
		val width: Int? = null,

		@field:SerializedName("animated")
		val animated: Boolean? = null,

		@field:SerializedName("processing")
		val processing: Processing? = null
	)

	data class DescriptionAnnotations(
		val any: Any? = null
	)

	data class TagsItem(

		@field:SerializedName("background_hash")
		val backgroundHash: String? = null,

		@field:SerializedName("is_promoted")
		val isPromoted: Boolean? = null,

		@field:SerializedName("background_is_animated")
		val backgroundIsAnimated: Boolean? = null,

		@field:SerializedName("thumbnail_hash")
		val thumbnailHash: Any? = null,

		@field:SerializedName("description")
		val description: String? = null,

		@field:SerializedName("display_name")
		val displayName: String? = null,

		@field:SerializedName("is_whitelisted")
		val isWhitelisted: Boolean? = null,

		@field:SerializedName("total_items")
		val totalItems: Int? = null,

		@field:SerializedName("accent")
		val accent: String? = null,

		@field:SerializedName("thumbnail_is_animated")
		val thumbnailIsAnimated: Boolean? = null,

		@field:SerializedName("followers")
		val followers: Int? = null,

		@field:SerializedName("following")
		val following: Boolean? = null,

		@field:SerializedName("name")
		val name: String? = null,

		@field:SerializedName("logo_hash")
		val logoHash: Any? = null,

		@field:SerializedName("description_annotations")
		val descriptionAnnotations: DescriptionAnnotations? = null,

		@field:SerializedName("logo_destination_url")
		val logoDestinationUrl: Any? = null
	)

	data class Processing(

		@field:SerializedName("status")
		val status: String? = null
	)

	data class ImagesItem(

		@field:SerializedName("comment_count")
		val commentCount: Any? = null,

		@field:SerializedName("in_most_viral")
		val inMostViral: Boolean? = null,

		@field:SerializedName("gifv")
		val gifv: String? = null,

		@field:SerializedName("ad_type")
		val adType: Int? = null,

		@field:SerializedName("link")
		val link: String? = null,

		@field:SerializedName("description")
		val description: String? = null,

		@field:SerializedName("mp4_size")
		val mp4Size: Int? = null,

		@field:SerializedName("section")
		val section: Any? = null,

		@field:SerializedName("title")
		val title: Any? = null,

		@field:SerializedName("type")
		val type: String? = null,

		@field:SerializedName("points")
		val points: Any? = null,

		@field:SerializedName("score")
		val score: Any? = null,

		@field:SerializedName("datetime")
		val datetime: Int? = null,

		@field:SerializedName("has_sound")
		val hasSound: Boolean? = null,

		@field:SerializedName("favorite_count")
		val favoriteCount: Any? = null,

		@field:SerializedName("id")
		val id: String? = null,

		@field:SerializedName("in_gallery")
		val inGallery: Boolean? = null,

		@field:SerializedName("vote")
		val vote: Any? = null,

		@field:SerializedName("views")
		val views: Int? = null,

		@field:SerializedName("height")
		val height: Int? = null,

		@field:SerializedName("downs")
		val downs: Any? = null,

		@field:SerializedName("bandwidth")
		val bandwidth: Long? = null,

		@field:SerializedName("nsfw")
		val nsfw: Any? = null,

		@field:SerializedName("is_ad")
		val isAd: Boolean? = null,

		@field:SerializedName("edited")
		val edited: String? = null,

		@field:SerializedName("ad_url")
		val adUrl: String? = null,

		@field:SerializedName("hls")
		val hls: String? = null,

		@field:SerializedName("tags")
		val tags: List<Any?>? = null,

		@field:SerializedName("mp4")
		val mp4: String? = null,

		@field:SerializedName("account_id")
		val accountId: Any? = null,

		@field:SerializedName("size")
		val size: Int? = null,

		@field:SerializedName("width")
		val width: Int? = null,

		@field:SerializedName("account_url")
		val accountUrl: Any? = null,

		@field:SerializedName("animated")
		val animated: Boolean? = null,

		@field:SerializedName("processing")
		val processing: Processing? = null,

		@field:SerializedName("ups")
		val ups: Any? = null,

		@field:SerializedName("favorite")
		val favorite: Boolean? = null
	)

	val imageList: List<ImagesItem> by lazy {
		getNewImageList()
	}

	private fun getNewImageList(): List<ImagesItem> {
		val newList = ArrayList<ImagesItem>()
		data?.filter {
			it?.link?.endsWith(".jpg") == true || it?.images?.getOrNull(0)?.link?.endsWith(".jpg") == true
		}?.forEach {

			var link: String
			if(it?.link?.endsWith(".jpg") == true) {
				link = it.link
			} else {
				link = it?.images?.getOrNull(0)?.link?: ""
			}
			newList.add(ImagesItem(id = it?.id, width = it?.width, height = it?.height, description = it?.description, title = it?.title, link = link))
		}

		return newList
	}
}