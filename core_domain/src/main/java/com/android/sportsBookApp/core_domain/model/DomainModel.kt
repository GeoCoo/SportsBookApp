package com.android.sportsBookApp.core_domain.model

import com.android.sportsBookApp.core_common.helpers.splitToPairByDash
import com.android.sportsBookApp.core_model.EventDto
import com.android.sportsBookApp.core_model.SportsEventsDto

data class SportsEventsDomain(
    val sportId: String,
    val sportName: String?,
    val activeEvents: List<EventDomain>? = listOf(),
    val originalEvents: List<EventDomain>? = listOf(),
    val isExpanded: Boolean = true,
    val hasFavorites: Boolean = false
)

data class EventDomain(
    var eventName: String,
    var eventId: String,
    var competitors: Pair<String, String>?,
    var sportId: String,
    var eventStartTime: Int,
    var isFavorite: Boolean = false
)

data class SingleEventDomain(
    val sportName: String?,
    val event: EventDomain
)

fun SportsEventsDto.toDomain(): SportsEventsDomain {
    val mappedEvents = this.activeEvents.map { it.toDomain() }

    return SportsEventsDomain(
        sportName = this.sportName ?: "",
        activeEvents = mappedEvents,
        originalEvents = mappedEvents,
        sportId = this.sportId ?: "",
    )
}

fun EventDto.toDomain(): EventDomain =
    EventDomain(
        eventName = this.eventName ?: "",
        eventId = this.eventId ?: "",
        competitors = this.competitors.splitToPairByDash(),
        sportId = this.sportId ?: "",
        eventStartTime = this.eventStartTime ?: 0,
    )

