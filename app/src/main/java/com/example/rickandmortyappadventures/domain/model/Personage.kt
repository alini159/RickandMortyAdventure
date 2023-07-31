package com.example.rickandmortyappadventures.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Personage(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("status") val img: String?,
    @SerializedName("species") val species: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("origin") val origin: Origin?,
    @SerializedName("location") val location: Origin?,
    @SerializedName("image") val image: String?,
    @SerializedName("episode") val episode : List<String>?,
) : Parcelable

