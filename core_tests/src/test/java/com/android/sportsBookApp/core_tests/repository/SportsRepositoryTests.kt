package com.android.sportsBookApp.core_tests.repository


import app.cash.turbine.test
import com.android.sportsBookApp.core_api.api.ApiClient
import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsRepositoryImpl
import com.android.sportsBookApp.core_data.repository.SportsResponse
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class SportsRepositoryTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    private lateinit var apiClient: ApiClient
    private lateinit var repository: SportsRepository

    @Before
    fun setup() {
        apiClient = mock(ApiClient::class.java)
        repository = SportsRepositoryImpl(apiClient)
    }

    @Test
    fun `Given successful response, When getSports is called, Then emit Success`() = runTest {
        // Given
        val mockList = listOf(SportsEventsDto(sportId = "football", sportName = "Football"))
        val response = Response.success(mockList)
        whenever(apiClient.retrieveSports()).thenReturn(response)

        // When / Then
        repository.getSports().test {
            val result = awaitItem()
            assert(result is SportsResponse.Success)
            assert((result as SportsResponse.Success).sports == mockList)
            awaitComplete()
        }
    }

    @Test
    fun `Given failed response, When getSports is called, Then emit Failed`() = runTest {
        // Given
        val errorResponse = Response.error<List<SportsEventsDto>>(
            404,
            ResponseBody.create(null, "Not Found")
        )
        whenever(apiClient.retrieveSports()).thenReturn(errorResponse)

        // When / Then
        repository.getSports().test {
            val result = awaitItem()
            assert(result is SportsResponse.Failed)
            assert((result as SportsResponse.Failed).errorMsg == "Response.error()")
            awaitComplete()
        }
    }
}
