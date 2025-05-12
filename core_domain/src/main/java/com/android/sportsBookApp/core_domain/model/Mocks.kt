package com.android.sportsBookApp.core_domain.model

import com.android.sportsBookApp.core_model.EventDto
import com.android.sportsBookApp.core_model.SportsEventsDto


fun providedMockSports(): List<SportsEventsDomain> {
    return listOf(
        SportsEventsDomain(
            sportName = "Football",
            sportId = "football",
            activeEvents = provideMockEvents().map { it.copy(isFavorite = false) },
            hasFavorites = true
        ),
        SportsEventsDomain(
            sportName = "Basketball",
            sportId = "basketball",
            activeEvents = provideMockEvents().map { it.copy(isFavorite = false) },
            hasFavorites = true
        ),
        SportsEventsDomain(
            sportName = "Tennis",
            sportId = "tennis",
            activeEvents = provideMockEvents().map { it.copy(isFavorite = false) },
            hasFavorites = true
        )
    )
}

fun provideMockEvents(): List<EventDomain> {
    return listOf(
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
        )
    )
}

fun provideMockEventDto():List<EventDto> = listOf(
    EventDto(
        eventName = "Match 1",
        eventId = "evt001",
        competitors = "Team A-Team B",
        sportId = "football",
        eventStartTime = 1715100000
    ),
    EventDto(
        eventName = "Match 2",
        eventId = "evt002",
        competitors = "Team C-Team D",
        sportId = "football",
        eventStartTime = 1715103600
    )
)

fun provideMockSportsDto(): List<SportsEventsDto> = listOf(
    SportsEventsDto(
        sportName = "Football",
        sportId = "football",
        activeEvents = provideMockEventDto()
    ),
    SportsEventsDto(
        sportName = "Basketball",
        sportId = "basketball",
        activeEvents = listOf(
            EventDto(
                eventName = "Basketball Match",
                eventId = "evt003",
                competitors = "Team X-Team Y",
                sportId = "basketball",
                eventStartTime = 1715110000
            )
        )
    )
)