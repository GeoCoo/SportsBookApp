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

    private val mockEventId = "event-123"
    private val mockFavorites = listOf("event-123", "event-456")

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        interactor = SportsInteractorImpl(sportsRepository, favoriteEventController)
    }

    @Test
    fun `Given Success from SportsRepository, When getSports called, Then emit SportsPartialState Success`() =
        coroutineRule.runTest {
            val mockDto = SportsEventsDto(sportId = "1")
            Mockito.`when`(sportsRepository.getSports()).thenReturn(flowOf(SportsResponse.Success(listOf(mockDto))))

            interactor.getSports().runFlowTest {
                assertTrue(awaitItem() is SportsPartialState.Success)
            }
        }

    @Test
    fun `Given Failed from SportsRepository, When getSports called, Then emit SportsPartialState Failed`() =
        coroutineRule.runTest {
            Mockito.`when`(sportsRepository.getSports()).thenReturn(flowOf(SportsResponse.Failed("Error")))

            interactor.getSports().runFlowTest {
                assertEquals("Error", (awaitItem() as SportsPartialState.Failed).errorMessage)
            }
        }

    @Test
    fun `Given Success from Controller, When addFavorite called, Then emit FavoritesPartialState Success`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.addFavorite(mockEventId))
                .thenReturn(flowOf(FavoriteEventsControllerPartialState.Success(mockFavorites)))

            interactor.addFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Success(mockFavorites), awaitItem())
            }
        }

    @Test
    fun `Given Fail from Controller, When addFavorite called, Then emit FavoritesPartialState Failed`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.addFavorite(mockEventId))
                .thenReturn(flowOf(FavoriteEventsControllerPartialState.Fail("Add failed")))

            interactor.addFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Failed("Add failed"), awaitItem())
            }
        }

    @Test
    fun `Given Success from Controller, When removeFavorite called, Then emit FavoritesPartialState Success`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.removeFavorite(mockEventId))
                .thenReturn(flowOf(FavoriteEventsControllerPartialState.Success(mockFavorites)))

            interactor.removeFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Success(mockFavorites), awaitItem())
            }
        }

    @Test
    fun `Given Fail from Controller, When removeFavorite called, Then emit FavoritesPartialState Failed`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.removeFavorite(mockEventId))
                .thenReturn(flowOf(FavoriteEventsControllerPartialState.Fail("Remove failed")))

            interactor.removeFavorite(mockEventId).runFlowTest {
                assertEquals(FavoritesPartialState.Failed("Remove failed"), awaitItem())
            }
        }

    @Test
    fun `Given Success from Controller, When getFavorites called, Then emit FavoritesPartialState Success`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.getFavorites())
                .thenReturn(flowOf(FavoriteEventsControllerPartialState.Success(mockFavorites)))

            interactor.getFavorites().runFlowTest {
                assertEquals(FavoritesPartialState.Success(mockFavorites), awaitItem())
            }
        }

    @Test
    fun `Given Fail from Controller, When getFavorites called, Then emit FavoritesPartialState Failed`() =
        coroutineRule.runTest {
            Mockito.`when`(favoriteEventController.getFavorites())
                .thenReturn(flowOf(FavoriteEventsControllerPartialState.Fail("No favorites")))

            interactor.getFavorites().runFlowTest {
                assertEquals(FavoritesPartialState.Failed("No favorites"), awaitItem())
            }
        }
}
