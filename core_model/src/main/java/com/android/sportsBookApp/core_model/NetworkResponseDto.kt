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

fun String?.splitToPairByDash(): Pair<String, String>? {
    if (this.isNullOrEmpty()) return null

    val parts = this.split("-")
    return if (parts.size == 2) {
        parts[0].trim() to parts[1].trim()
    } else {
        null
    }
}
