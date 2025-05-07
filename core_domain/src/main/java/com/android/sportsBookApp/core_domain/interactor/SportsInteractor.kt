package com.android.sportsBookApp.core_domain.interactor


import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsResponse
import com.android.sportsBookApp.core_model.SportsEventsDomain
import com.android.sportsBookApp.core_model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface SportsInteractor {
    fun getSports(): Flow<SportsPartialState>
}

class SportsInteractorImpl @Inject constructor(private val sportsRepository: SportsRepository) :
    SportsInteractor {
    override fun getSports(): Flow<SportsPartialState> = flow {
        sportsRepository.getSports().collect { response ->
            when (response) {
                is SportsResponse.Success -> emit(SportsPartialState.Success(response.sports?.map { it.toDomain() }))
                is SportsResponse.Failed -> emit(SportsPartialState.Failed(response.errorMsg))
            }
        }

    }
}



sealed class SportsPartialState {
    data class Success(val sports: List<SportsEventsDomain>?) : SportsPartialState()
    data class Failed(val errorMessage: String) : SportsPartialState()
}