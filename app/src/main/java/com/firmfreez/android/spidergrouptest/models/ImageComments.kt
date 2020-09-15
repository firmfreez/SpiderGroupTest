package com.firmfreez.android.spidergrouptest.models

import com.google.gson.annotations.SerializedName

data class ImageComments(

	//Это и есть список комметариев
	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
{
	data class ChildrenItem(

		@field:SerializedName("downs")
		val downs: Int? = null,

		@field:SerializedName("author")
		val author: String? = null,

		@field:SerializedName("has_admin_badge")
		val hasAdminBadge: Boolean? = null,

		@field:SerializedName("album_cover")
		val albumCover: Any? = null,

		@field:SerializedName("platform")
		val platform: String? = null,

		@field:SerializedName("points")
		val points: Int? = null,

		@field:SerializedName("datetime")
		val datetime: Int? = null,

		@field:SerializedName("deleted")
		val deleted: Boolean? = null,

		@field:SerializedName("children")
		val children: List<Any?>? = null,

		@field:SerializedName("parent_id")
		val parentId: Int? = null,

		@field:SerializedName("ups")
		val ups: Int? = null,

		@field:SerializedName("comment")
		val comment: String? = null,

		@field:SerializedName("on_album")
		val onAlbum: Boolean? = null,

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("image_id")
		val imageId: String? = null,

		@field:SerializedName("author_id")
		val authorId: Int? = null,

		@field:SerializedName("vote")
		val vote: Any? = null
	)

	data class DataItem(

		@field:SerializedName("downs")
		val downs: Int? = null,

		@field:SerializedName("author")
		val author: String? = null,

		@field:SerializedName("has_admin_badge")
		val hasAdminBadge: Boolean? = null,

		@field:SerializedName("album_cover")
		val albumCover: Any? = null,

		@field:SerializedName("platform")
		val platform: String? = null,

		@field:SerializedName("points")
		val points: Int? = null,

		@field:SerializedName("datetime")
		val datetime: Int? = null,

		@field:SerializedName("deleted")
		val deleted: Boolean? = null,

		@field:SerializedName("children")
		val children: List<ChildrenItem?>? = null,

		@field:SerializedName("parent_id")
		val parentId: Int? = null,

		@field:SerializedName("ups")
		val ups: Int? = null,

		@field:SerializedName("comment")
		val comment: String? = null,

		@field:SerializedName("on_album")
		val onAlbum: Boolean? = null,

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("image_id")
		val imageId: String? = null,

		@field:SerializedName("author_id")
		val authorId: Int? = null,

		@field:SerializedName("vote")
		val vote: Any? = null
	)
}