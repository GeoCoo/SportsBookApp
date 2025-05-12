package com.android.sportsBookApp.core_tests.controller

import com.android.sportsBookApp.core_domain.controller.FAVORITES
import com.android.sportsBookApp.core_domain.controller.FavoriteEventController
import com.android.sportsBookApp.core_domain.controller.FavoriteEventControllerImpl
import com.android.sportsBookApp.core_domain.controller.FavoriteEventsControllerPartialState
import com.android.sportsBookApp.core_domain.controller.PreferencesController
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_resources.provider.ResourceProvider
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.runFlowTest
import com.android.sportsBookApp.core_tests.runTest
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Spy

class TestFavoriteEventController {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    private lateinit var controller: FavoriteEventController

    @Spy
    private lateinit var preferencesController: PreferencesController

    @Spy
    private lateinit var gson: Gson

    @Spy
    private lateinit var resourceProvider: ResourceProvider

    private lateinit var favoriteList: MutableList<String>
    private lateinit var favoriteListJson: String

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)

        favoriteList = mutableListOf("football_event_id", "basketball_event_id")
        favoriteListJson = Gson().toJson(favoriteList)

        controller = FavoriteEventControllerImpl(
            resourceProvider = resourceProvider,
            preferencesController = preferencesController,
            gson = gson
        )
    }

    @Test
    fun `When getFavorites is called and list is not empty, then correct list is emitted`() =
        coroutineRule.runTest {
            `when`(preferencesController.getString(FAVORITES, "")).thenReturn(favoriteListJson)

            controller.getFavorites().runFlowTest {
                assertEquals(favoriteList, awaitItem())
            }
        }

    @Test
    fun `When getFavorites is called and list is empty, then empty list is emitted`() =
        coroutineRule.runTest {
            `when`(preferencesController.getString(FAVORITES, "")).thenReturn("")

            controller.getFavorites().runFlowTest {
                assertTrue(awaitItem()?.isEmpty() == true)
            }
        }

    @Test
    fun `When addFavorite is called with new ID, then Success is emitted`() =
        coroutineRule.runTest {
            val newId = "eventId"
            val expectedList = favoriteList + newId
            val expectedJson = Gson().toJson(expectedList)

            `when`(preferencesController.getString(FAVORITES, "")).thenReturn(favoriteListJson)
            `when`(gson.toJson(anyList<String>())).thenReturn(expectedJson)

            controller.addFavorite(newId).runFlowTest {
                assertEquals(FavoriteEventsControllerPartialState.Success(expectedList), awaitItem())
            }
        }

    @Test
    fun `When addFavorite is called with existing ID, then Fail is emitted`() =
        coroutineRule.runTest {
            val existingId = "football_event_id"
            val errorMsg = "Already exists"

            `when`(preferencesController.getString(FAVORITES, "")).thenReturn(favoriteListJson)
            `when`(resourceProvider.getString(R.string.generic_error_msg)).thenReturn(errorMsg)

            controller.addFavorite(existingId).runFlowTest {
                assertEquals(FavoriteEventsControllerPartialState.Fail(errorMsg), awaitItem())
            }
        }

    @Test
    fun `When removeFavorite is called with existing ID, then Success is emitted`() =
        coroutineRule.runTest {
            val idToRemove = "football_event_id"
            val expectedList = favoriteList.filter { it != idToRemove }
            val expectedJson = Gson().toJson(expectedList)

            `when`(preferencesController.getString(FAVORITES, "")).thenReturn(favoriteListJson)
            `when`(gson.toJson(anyList<String>())).thenReturn(expectedJson)

            controller.removeFavorite(idToRemove).runFlowTest {
                assertEquals(FavoriteEventsControllerPartialState.Success(expectedList), awaitItem())
            }
        }

    @Test
    fun `When removeFavorite is called with non-existing ID, then Fail is emitted`() =
        coroutineRule.runTest {
            val nonExistingId = "eventId"
            val errorMsg = "Not found"

            `when`(preferencesController.getString(FAVORITES, "")).thenReturn(favoriteListJson)
            `when`(resourceProvider.getString(R.string.generic_error_msg)).thenReturn(errorMsg)

            controller.removeFavorite(nonExistingId).runFlowTest {
                assertEquals(FavoriteEventsControllerPartialState.Fail(errorMsg), awaitItem())
            }
        }
}
