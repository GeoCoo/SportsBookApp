package com.android.sportsBookApp.core_tests.repository

import com.android.sportsBookApp.core_api.api.ApiClient
import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsRepositoryImpl
import com.android.sportsBookApp.core_data.repository.SportsResponse
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.runFlowTest
import com.android.sportsBookApp.core_tests.runTest
import junit.framework.TestCase.assertEquals
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import retrofit2.Response

class SportsRepositoryImplTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Spy
    private lateinit var apiClient: ApiClient

    @Spy
    private lateinit var resourceProvider: ResourceProvider

    @Spy
    private lateinit var repository: SportsRepository

    private val mockDtoList = listOf(SportsEventsDto(sportId = "1"))

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        `when`(resourceProvider.getString(R.string.generic_error_msg)).thenReturn("Something went wrong")
        `when`(resourceProvider.getString(R.string.no_sport_events)).thenReturn("No sport events")

        repository = SportsRepositoryImpl(apiClient, resourceProvider)
    }

    @Test
    fun `Given successful response with data, When getSports called, Then emit Success`() = coroutineRule.runTest {
        `when`(apiClient.retrieveSports()).thenReturn(Response.success(mockDtoList))

        repository.getSports().runFlowTest {
            assertEquals(SportsResponse.Success(mockDtoList), awaitItem())
        }
    }

    @Test
    fun `Given successful response with empty body, When getSports called, Then emit Error`() = coroutineRule.runTest {
        `when`(apiClient.retrieveSports()).thenReturn(Response.success(null))

        repository.getSports().runFlowTest {
            assertEquals(SportsResponse.NoData("No sport events"), awaitItem())
        }
    }

    @Test
    fun `Given failed response, When getSports called, Then emit Failed`() = coroutineRule.runTest {
        val errorResponse = Response.error<List<SportsEventsDto>>(500,
            "Internal Server Error".toResponseBody(null)
        )
        `when`(apiClient.retrieveSports()).thenReturn(errorResponse)

        repository.getSports().runFlowTest {
            assertEquals(SportsResponse.Failed("Something went wrong"), awaitItem())
        }
    }
}
