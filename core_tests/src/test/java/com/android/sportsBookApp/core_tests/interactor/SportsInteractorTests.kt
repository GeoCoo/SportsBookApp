package com.android.sportsBookApp.core_tests.interactor

import com.android.sportsBookApp.core_data.repository.SportsRepository
import com.android.sportsBookApp.core_data.repository.SportsResponse
import com.android.sportsBookApp.core_domain.controller.FavoriteEventController
import com.android.sportsBookApp.core_domain.controller.FavoriteEventsControllerPartialState
import com.android.sportsBookApp.core_domain.interactor.FavoritesPartialState
import com.android.sportsBookApp.core_domain.interactor.SportsInteractor
import com.android.sportsBookApp.core_domain.interactor.SportsInteractorImpl
import com.android.sportsBookApp.core_domain.interactor.SportsPartialState
import com.android.sportsBookApp.core_model.SportsEventsDto
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.runFlowTest
import com.android.sportsBookApp.core_tests.runTest
import com.android.sportsBookApp.core_tests.toFlow
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Spy

class TestSportsInteractor {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    private lateinit var interactor: SportsInteractor

    @Spy
    private lateinit var sportsRepository: SportsRepository

    @Spy
    private lateinit var favoriteEventController: FavoriteEventController

    private val mockEventId = "eventId"
    private val mockFavorites = listOf("football_event_id", "basketball_event_id")

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        interactor = SportsInteractorImpl(sportsRepository, favoriteEventController)
    }

    @Test
    fun `Given Success from SportsRepository, When getSports called, Then emit SportsPartialState Success`() =
        coroutineRule.runTest {
            val mockDto = SportsEventsDto(sportId = "1")
            val response = SportsResponse.Success(listOf(mockDto))
            Mockito.`when`(sportsRepository.getSports()).thenReturn(response.toFlow())

            interactor.getSports().runFlowTest {
                assertTrue(awaitItem() is SportsPartialState.Success)
            }
        }

    @Test
    fun `Given Failed from SportsRepository, When getSports called, Then emit SportsPartialState Failed`() =
        coroutineRule.runTest {
            val response = SportsResponse.Failed("Error")
            Mockito.`when`(sportsRepository.getSports()).thenReturn(response.toFlow())

            interactor.getSports().runFlowTest {
                assertEquals("Error", (awaitItem() as SportsPartialState.Failed).errorMessage)
            }
        }

    @Test
    fun `Given NoData from SportsRepository, When getSports called, Then emit SportsPartialState NoData`() =
        coroutineRule.runTest {
            val response = SportsResponse.NoData("no data")
            Mockito.`when`(sportsRepository.getSports()).thenReturn(response.toFlow())

            interactor.getSports().runFlowTest {
                assertEquals(SportsPartialState.NoData("no data"), awaitItem())
            }
        }

    @Test
    fun `Given Success from Controller, When addFavorite called, Then emit FavoritesPartialState Success`() =
        coroutineRule.runTest {
            val response = FavoriteEventsControllerPartialState.Success(mockFavorites)
            Mockito.`when`(favoriteEventController.addFavorite(mockEventId))
                .thenReturn(response.toFlow())

            interactor.addFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Success(mockFavorites), awaitItem())
            }
        }

    @Test
    fun `Given Fail from Controller, When addFavorite called, Then emit FavoritesPartialState Failed`() =
        coroutineRule.runTest {
            val response = FavoriteEventsControllerPartialState.Fail("Add failed")
            Mockito.`when`(favoriteEventController.addFavorite(mockEventId))
                .thenReturn(response.toFlow())

            interactor.addFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Failed("Add failed"), awaitItem())
            }
        }

    @Test
    fun `Given Success from Controller, When removeFavorite called, Then emit FavoritesPartialState Success`() =
        coroutineRule.runTest {
            val response = FavoriteEventsControllerPartialState.Success(mockFavorites)
            Mockito.`when`(favoriteEventController.removeFavorite(mockEventId))
                .thenReturn(response.toFlow())

            interactor.removeFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Success(mockFavorites), awaitItem())
            }
        }

    @Test
    fun `Given Fail from Controller, When removeFavorite called, Then emit FavoritesPartialState Failed`() =
        coroutineRule.runTest {
            val response  = FavoriteEventsControllerPartialState.Fail("Remove failed")
            Mockito.`when`(favoriteEventController.removeFavorite(mockEventId))
                .thenReturn(response.toFlow())

            interactor.removeFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Failed("Remove failed"), awaitItem())
            }
        }

    @Test
    fun `Given Success from Controller, When getFavorites called, Then emit List of strings`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.getFavorites())
                .thenReturn(mockFavorites.toFlow())

            interactor.getFavorites().runFlowTest {
                assertEquals(mockFavorites, awaitItem())
            }
        }

    @Test
    fun `Given Empty from Controller, When getFavorites called, Then emit empty list`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.getFavorites())
                .thenReturn(flowOf(emptyList()))

            interactor.getFavorites().runFlowTest {
                assertEquals(emptyList<String>(), awaitItem())
            }
        }
}
