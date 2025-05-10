package com.android.sportsBookApp.core_model

import com.google.gson.annotations.SerializedName

data class SportsEventsDto(
    @SerializedName("d") var sportName: String? = null,
    @SerializedName("e") var activeEvents: List<EventDto> = listOf(),
    @SerializedName("i") var sportId: String? = null
)

data class EventDto(
    @SerializedName("d") var eventName: String? = null,
    @SerializedName("i") var eventId: String? = null,
    @SerializedName("sh") var competitors: String? = null,
    @SerializedName("si") var sportId: String? = null,
    @SerializedName("tt") var eventStartTime: Int? = null
)

