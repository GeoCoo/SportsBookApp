package com.android.sportsBookApp.core_tests.viewModel

import com.android.sportsBookApp.core_domain.interactor.FavoritesPartialState
import com.android.sportsBookApp.core_domain.interactor.SportsInteractor
import com.android.sportsBookApp.core_domain.interactor.SportsPartialState
import com.android.sportsBookApp.core_domain.model.SportsEventsDomain
import com.android.sportsBookApp.core_domain.model.provideMockEvents
import com.android.sportsBookApp.core_domain.model.providedMockSports
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.RobolectricTest
import com.android.sportsBookApp.core_tests.runFlowTest
import com.android.sportsBookApp.core_tests.runTest
import com.android.sportsBookApp.core_tests.toFlow
import com.android.sportsBookApp.feature_main_screen.ui.Effect
import com.android.sportsBookApp.feature_main_screen.ui.Event
import com.android.sportsBookApp.feature_main_screen.ui.MainViewModel
import com.android.sportsBookApp.feature_main_screen.ui.State
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.kotlin.times

class MainViewModelTest : RobolectricTest() {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Spy
    private lateinit var sportsInteractor: SportsInteractor

    @Spy
    private lateinit var resourceProvider: ResourceProvider

    private lateinit var viewModel: MainViewModel

    private val mockSports = providedMockSports()
    private val mockFavorites = listOf("foot_event_id", "basket_event_id")
    private var initialState = State(isLoading = true)

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = MainViewModel(sportsInteractor, resourceProvider)
    }

    @Test
    fun `Given GetSportsData with success, Then state updates`() =
        coroutineRule.runTest {
            val response = SportsPartialState.Success(mockSports)
            `when`(sportsInteractor.getSports()).thenReturn(response.toFlow())

            viewModel.setEvent(Event.GetSportsData(mockFavorites))

            Mockito.verify(sportsInteractor, times(1)).getSports()

            viewModel.viewStateHistory.runFlowTest {
                val state = awaitItem()
                assertEquals(false, state.isLoading)
                assertTrue(state.sportEvents?.isNotEmpty() == true)
            }
        }

    @Test
    fun `Given GetSportsData with no data, Then state updates with error`() =
        coroutineRule.runTest {
            val response = SportsPartialState.NoData("No data")
            `when`(sportsInteractor.getSports()).thenReturn(response.toFlow())

            viewModel.setEvent(Event.GetSportsData(null))

            Mockito.verify(sportsInteractor, times(1)).getSports()
            viewModel.viewStateHistory.runFlowTest {
                assertEquals(
                    awaitItem(),
                    initialState.copy(
                        isLoading = false
                    )
                )
            }

            viewModel.effect.runFlowTest {
                assertEquals(Effect.ShowMessage("No data"), awaitItem())
            }
        }

    @Test
    fun `Given ToggleFavoriteEvent remove success, Then state updates with new favorites`() =
        coroutineRule.runTest {
            val eventId = "eventId"
            val updatedFavorites = listOf("foot_even_id", "basket_event_id")
            val response = FavoritesPartialState.Success(updatedFavorites)
            `when`(sportsInteractor.removeFavorite(eventId))
                .thenReturn(response.toFlow())

            viewModel.setEvent(
                Event.ToggleFavoriteEvent(
                    SportsEventsDomain(
                        sportId = "eventId",
                        sportName = "football"
                    ), eventId to true
                )
            )

            viewModel.viewStateHistory.runFlowTest {
                val state = awaitItem()
                assertEquals(updatedFavorites, state.savedFavorites)
            }
        }

    @Test
    fun `Given ToggleFavoriteEvent add fails, Then emit error message`() = coroutineRule.runTest {
        val eventId = "eventId"
        val response = FavoritesPartialState.Failed("Add failed")
        `when`(sportsInteractor.addFavorite(eventId))
            .thenReturn(response.toFlow())

        viewModel.setEvent(
            Event.ToggleFavoriteEvent(
                SportsEventsDomain(
                    sportId = "eventId",
                    sportName = "football"
                ), eventId to false
            )
        )

        viewModel.effect.runFlowTest {
            assertEquals(Effect.ShowMessage("Add failed"), awaitItem())
        }
    }

    @Test
    fun `Given GetSavedFavorites, Then saved favorites are loaded and mapped`() =
        coroutineRule.runTest {
            `when`(sportsInteractor.getFavorites()).thenReturn(mockFavorites.toFlow())

            viewModel.setEvent(Event.GetSavedFavorites)

            Mockito.verify(sportsInteractor, times(1)).getFavorites()

            viewModel.viewStateHistory.runFlowTest {
                val state = awaitItem()
                assertEquals(
                    state,
                    initialState.copy(savedFavorites = mockFavorites, sportEvents = listOf())
                )
            }
        }

    @Test
    fun `Given ToggleFavoriteEventNotEnabled, Then show no favorite message`() =
        coroutineRule.runTest {
            `when`(resourceProvider.getString(R.string.no_sport_favs_msg)).thenReturn("Favorites not enabled")

            viewModel.setEvent(Event.ToggleFavoriteEventNotEnabled)

            viewModel.effect.runFlowTest {
                assertEquals(Effect.ShowMessage("Favorites not enabled"), awaitItem())
            }
        }

    @Test
    fun `Given HideShowFavorites true with no favorites, Then ShowMessage effect is emitted`() = coroutineRule.runTest {
        val sportId = "basketball"
        val allSports = providedMockSports().map { sport ->
            sport.copy(activeEvents = sport.activeEvents?.map { it.copy(isFavorite = false) })
        }

        `when`(resourceProvider.getString(R.string.no_sport_favs_msg)).thenReturn("No favorites")

        viewModel.setEvent(
            Event.HideShowFavorites(
                sportId = sportId,
                toggleFavorites = true,
                sportEvents = allSports
            )
        )

        viewModel.effect.runFlowTest {
            assertEquals(Effect.ShowMessage("No favorites"), awaitItem())
        }

        viewModel.viewStateHistory.runFlowTest {
            val state = awaitItem()
            val unchangedSport = state.sportEvents?.find { it.sportId == sportId }
            assertEquals(3, unchangedSport?.activeEvents?.size) // all events still there
        }
    }

    @Test
    fun `Given HideShowFavorites false, Then restore original event list`() = coroutineRule.runTest {
        val sportId = "football"
        val favoritesOnly = provideMockEvents().map {
            it.copy(isFavorite = true)
        }

        val sport = SportsEventsDomain(
            sportId = sportId,
            sportName = "Football",
            activeEvents = favoritesOnly,
            originalEvents = provideMockEvents(),
            hasFavorites = true
        )

        val allSports = listOf(sport)

        viewModel.setEvent(
            Event.HideShowFavorites(
                sportId = sportId,
                toggleFavorites = false,
                sportEvents = allSports
            )
        )

        viewModel.viewStateHistory.runFlowTest {
            val state = awaitItem()
            val restoredSport = state.sportEvents?.find { it.sportId == sportId }
            assertEquals(3, restoredSport?.activeEvents?.size)
            assertEquals(null, restoredSport?.originalEvents)
            assertEquals(false, restoredSport?.hasFavorites)
        }
    }
}
