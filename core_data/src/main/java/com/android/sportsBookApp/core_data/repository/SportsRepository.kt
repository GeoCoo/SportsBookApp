package com.android.sportsBookApp.core_data.repository

import com.android.sportsBookApp.core_api.api.ApiClient
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface SportsRepository {
    fun getSports(): Flow<SportsResponse>
}

class SportsRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val resourceProvider: ResourceProvider
) : SportsRepository {

    override fun getSports(): Flow<SportsResponse> = flow {
        val response = apiClient.retrieveSports()

        when {
            response.isSuccessful && !response.body().isNullOrEmpty() -> {
                emit(SportsResponse.Success(response.body()))
            }

            response.isSuccessful && response.body().isNullOrEmpty() -> {
                emit(SportsResponse.NoData(resourceProvider.getString(R.string.no_sport_events)))
            }

            else -> {
                emit(SportsResponse.Failed(resourceProvider.getString(R.string.generic_error_msg)))
            }
        }
    }
}

sealed class SportsResponse {
    data class Success(val sports: List<SportsEventsDto>?) : SportsResponse()
    data class Failed(val errorMsg: String) : SportsResponse()
    data class NoData(val msg: String) : SportsResponse()

}