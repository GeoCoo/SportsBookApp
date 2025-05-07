package com.android.sportsBookApp.core_api.api

import com.android.sportsBookApp.core_model.SportsEventsDto
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface ApiService {

    @GET("bets")
    suspend fun retrieveBets(): Response<SportsEventsDto>
}


interface ApiClient {
    suspend fun retrieveBets():Response<SportsEventsDto>
}

class ApiClientImpl @Inject constructor(private val apiService: ApiService) : ApiClient {
    override suspend fun retrieveBets(): Response<SportsEventsDto> = apiService.retrieveBets()
}