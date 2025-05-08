package com.android.sportsBookApp.core_domain.model

import com.android.sportsBookApp.core_model.EventDto
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_model.splitToPairByDash

data class SportsEventsDomain(
    var sportName: String? = "",
    var isExpanded: Boolean = true,
    val hasFavoritess : Boolean = false,
    var activeEvents: List<EventDomain> = listOf(),
    var sportId: String? = ""
)

data class EventDomain(
    var eventName: String,
    var eventId: String,
    var competitors: Pair<String, String>?,
    var sportId: String,
    var eventStartTime: Int,
    var isFavorite: Boolean = false
)

fun SportsEventsDto.toDomain(): SportsEventsDomain =
    SportsEventsDomain(
        sportName = this.sportName ?: "",
        activeEvents = this.activeEvents.map { it.toDomain() },
        sportId = this.sportId ?: ""
    )

fun EventDto.toDomain(): EventDomain =
    EventDomain(
        eventName = this.eventName ?: "",
        eventId = this.eventId ?: "",
        competitors = this.competitors.splitToPairByDash(),
        sportId = this.sportId ?: "",
        eventStartTime = this.eventStartTime ?: 0
    )