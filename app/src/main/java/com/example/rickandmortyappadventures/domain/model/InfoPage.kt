package com.example.rickandmortyappadventures.domain.model

import com.google.gson.annotations.SerializedName

data class InfoPage(
    @SerializedName("count") var count: Int,
    @SerializedName("pages") var pages: Int,
    @SerializedName("next") var next: String,
    @SerializedName("prev") var prev: String
)
