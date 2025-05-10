package com.android.sportsBookApp.core_tests.api

import com.android.sportsBookApp.core_api.api.ApiClient
import com.android.sportsBookApp.core_api.api.ApiClientImpl
import com.android.sportsBookApp.core_api.api.ApiService
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import retrofit2.Response

class ApiClientImplTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Spy
    private lateinit var apiService: ApiService

    private lateinit var apiClient: ApiClient

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        apiClient = ApiClientImpl(apiService)
    }

    @Test
    fun `When retrieveSports is called Then ApiService#retrieveSports is called`() = coroutineRule.runTest {
        // Given
        val expectedResponse = Response.success(emptyList<SportsEventsDto>())
        `when`(apiService.retrieveSports()).thenReturn(expectedResponse)

        // When
        val result = apiClient.retrieveSports()

        // Then
        verify(apiService, times(1)).retrieveSports()
        assert(result == expectedResponse)
    }
}
