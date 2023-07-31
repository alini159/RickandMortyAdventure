package com.example.rickandmortyappadventures.domain.model

import com.google.gson.annotations.SerializedName

data class PersonageList(
    @SerializedName("info") var info: InfoPage,
    @SerializedName("results") var results: List<Personage>
)
