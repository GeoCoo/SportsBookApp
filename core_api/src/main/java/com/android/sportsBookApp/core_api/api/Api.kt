package com.android.sportsBookApp.core_api.api

import com.android.sportsBookApp.core_model.SportsEventsDto
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject


const val baseUrl = "https://ios-kaizen.github.io/"

interface ApiService {
    @GET("MockSports/sports.json")
    suspend fun retrieveSports(): Response<List<SportsEventsDto>>
}

interface ApiClient {
    suspend fun retrieveSports(): Response<List<SportsEventsDto>>
}

class ApiClientImpl @Inject constructor(private val apiService: ApiService) : ApiClient {
    override suspend fun retrieveSports(): Response<List<SportsEventsDto>> =
        apiService.retrieveSports()
}