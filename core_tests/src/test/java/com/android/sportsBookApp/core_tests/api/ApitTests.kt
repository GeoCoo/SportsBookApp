package com.android.sportsBookApp.core_tests.api

import com.android.sportsBookApp.core_api.api.ApiClient
import com.android.sportsBookApp.core_api.api.ApiClientImpl
import com.android.sportsBookApp.core_api.api.ApiService
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.runTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalCoroutinesApi::class)
class ApiClientTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: ApiService
    private lateinit var apiClient: ApiClient

    @Before
    fun setUp() {
        mockWebServer = MockWebServer().apply { start() }

        val retrofit = Retrofit.Builder().baseUrl(mockWebServer.url("/")) // Use mock server's URL
            .addConverterFactory(GsonConverterFactory.create()).build()

        apiService = retrofit.create(ApiService::class.java)
        apiClient = ApiClientImpl(apiService)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
        coroutineRule.cancelScopeAndDispatcher()
    }

    @Test
    fun `Given valid sports JSON, When retrieveSports is called, Then it returns parsed list`() =
        coroutineRule.runTest {
            // Given
            val mockResponse = """
    [
        {
            "i": "football",
            "d": "Football",
            "e": [
                {
                    "i": "123",
                    "d": "Match A",
                    "sh": "Team A-Team B",
                    "si": "football",
                    "tt": 1715100000
                }
            ]
        }
    ]
""".trimIndent()

            mockWebServer.enqueue(
                MockResponse().setResponseCode(200).setBody(mockResponse)
            )

            // When
            val response = apiClient.retrieveSports()

            // Then
            assertTrue(response.isSuccessful)
            val sport = response.body()?.firstOrNull()
            val event = sport?.activeEvents?.firstOrNull()

            assertEquals("football", sport?.sportId)
            assertEquals("Football", sport?.sportName)
            assertEquals("123", event?.eventId)
            assertEquals("Match A", event?.eventName)
            assertEquals("Team A-Team B", event?.competitors)
            assertEquals(1715100000, event?.eventStartTime)
        }

    @Test
    fun `Given error response, When retrieveSports is called, Then response is not successful`() =
        coroutineRule.runTest {
            // Given
            mockWebServer.enqueue(
                MockResponse().setResponseCode(404).setBody("Not Found")
            )

            // When
            val response = apiClient.retrieveSports()

            // Then
            assertFalse(response.isSuccessful)
            assertEquals(404, response.code())
        }
}
