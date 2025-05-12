package com.android.sportsBookApp.core_tests.repository

import com.android.sportsBookApp.core_api.api.ApiClient
import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsRepositoryImpl
import com.android.sportsBookApp.core_data.repository.SportsResponse
import com.android.sportsBookApp.core_domain.model.provideMockSportsDto
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.runFlowTest
import com.android.sportsBookApp.core_tests.runTest
import junit.framework.TestCase.assertEquals
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stub
import retrofit2.Response

class TestSportsRepositoryImpl {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Spy
    private lateinit var apiClient: ApiClient
    @Spy
    private lateinit var resourceProvider: ResourceProvider
    private lateinit var repository: SportsRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = SportsRepositoryImpl(apiClient, resourceProvider)
    }

    @After
    fun tearDown() {
        coroutineRule.cancelScopeAndDispatcher()
    }

    @Test
    fun `Given successful and non-empty response, When getSports is called, Then Success is emitted`() {
        coroutineRule.runTest {
            val response: Response<List<SportsEventsDto>?> = Response.success(provideMockSportsDto())

            requestRetireveSportssInterceptor(response)

            repository.getSports().runFlowTest {
                assertEquals(SportsResponse.Success(provideMockSportsDto()), awaitItem())
            }
        }
    }

    @Test
    fun `Given successful but empty response, When getSports is called, Then NoData is emitted`() {
        coroutineRule.runTest {
            val response: Response<List<SportsEventsDto>?> = Response.success(emptyList())
            `when`(resourceProvider.getString(R.string.no_sport_events)).thenReturn("No data available")

            requestRetireveSportssInterceptor(response)

            repository.getSports().runFlowTest {
                assertEquals(SportsResponse.NoData("No data available"), awaitItem())
            }
        }
    }

    @Test
    fun `Given failed response, When getSports is called, Then Failed is emitted`() {
        coroutineRule.runTest {
            val response: Response<List<SportsEventsDto>?> = Response.error(500,
                "Internal error".toResponseBody(null)
            )
            `when`(resourceProvider.getString(R.string.generic_error_msg)).thenReturn("Something went wrong")

            requestRetireveSportssInterceptor(response)

            repository.getSports().runFlowTest {
                assertEquals(SportsResponse.Failed("Something went wrong"), awaitItem())
            }
        }
    }


    private fun requestRetireveSportssInterceptor(response: Response<List<SportsEventsDto>?>) {
        apiClient.stub {
            onBlocking {
                retrieveSports()
            }.doReturn(
                response
            )
        }
    }
}
