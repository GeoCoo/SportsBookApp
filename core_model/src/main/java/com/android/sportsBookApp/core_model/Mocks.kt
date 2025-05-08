package com.android.sportsBookApp.core_model

fun proviedMockSports(): List<SportsEventsDomain> {
    return listOf(
        SportsEventsDomain(
            sportName = "Football",
            activeEvents = provideMockEvents(),
            sportId = "football"
        ),
        SportsEventsDomain(
            sportName = "Basketball",
            activeEvents = provideMockEvents(),
            sportId = "basketball"
        ),
        SportsEventsDomain(
            sportName = "Tennis",
            activeEvents = provideMockEvents(),
            sportId = "tennis"
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