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

data class EventDomain(
    var eventName: String,
    var eventId: String,
    var competitors: Pair<String, String>,
    var sportId: String,
    var eventStartTime: Int
)

fun EventDto.toDomain(): EventDomain =
    EventDomain(
        eventName = this.eventName ?: "",
        eventId = this.eventId ?: "",
        competitors = this.competitors.splitToPairByDash(),
        sportId = this.sportId ?: "",
        eventStartTime = this.eventStartTime ?: 0
    )

fun String?.splitToPairByDash(): Pair<String, String> {
    val parts = this?.split("-")
    require(parts?.size == 2)
    return parts[0] to parts[1]
}

val mockEvents = listOf(
    EventDomain(
        eventName = "Match 1",
        eventId = "evt001",
        competitors = "MossFK" to "VikingFK",
        sportId = "football",
        eventStartTime = 1715100000
    ),
    EventDomain(
        eventName = "Match 2",
        eventId = "evt002",
        competitors = "Team A" to "Team B",
        sportId = "basketball",
        eventStartTime = 1715103600
    ),
    EventDomain(
        eventName = "Match 3",
        eventId = "evt003",
        competitors = "Alpha FC" to "Beta FC",
        sportId = "football",
        eventStartTime = 1715107200
    ))