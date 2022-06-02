package com.anotherteam.kisahnabi

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseRasulNabi(

	@field:SerializedName("ResponseRasulNabi")
	val responseRasulNabi: List<ResponseRasulNabiItem?>? = null
) : Parcelable

@Parcelize
data class ResponseRasulNabiItem(

	@field:SerializedName("usia")
	val usia: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("tp_kelahiran")
	val tpKelahiran: String? = null
) : Parcelable
