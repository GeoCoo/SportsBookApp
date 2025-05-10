package com.android.sportsBookApp.core_data.repository

import android.util.Log
import com.android.sportsBookApp.core_api.api.ApiClient
import com.android.sportsBookApp.core_model.SportsEventsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface SportsRepository {
    fun getSports(): Flow<SportsResponse>
}

class SportsRepositoryImpl @Inject constructor(private val apiClient: ApiClient) :
    SportsRepository {
    override fun getSports(): Flow<SportsResponse> = flow {
        val response = apiClient.retrieveSports()

        if (response.isSuccessful) {
            emit(SportsResponse.Success(response.body()))
        } else {
            emit(SportsResponse.Failed(response.message()))
        }
    }
}

sealed class SportsResponse {
    data class Success(val sports: List<SportsEventsDto>?) : SportsResponse()
    data class Failed(val errorMsg: String) : SportsResponse()
}