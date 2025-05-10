package com.android.sportsBookApp.core_tests.controllers

import com.android.sportsBookApp.core_domain.controller.FAVORITES
import com.android.sportsBookApp.core_domain.controller.FavoriteEventController
import com.android.sportsBookApp.core_domain.controller.FavoriteEventControllerImpl
import com.android.sportsBookApp.core_domain.controller.FavoriteEventsControllerPartialState
import com.android.sportsBookApp.core_domain.controller.PreferencesController
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.runFlowTest
import com.android.sportsBookApp.core_tests.runTest
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Spy

class TestFavoriteEventController {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    private lateinit var favoriteEventController: FavoriteEventController

    @Spy
    private lateinit var preferencesController: PreferencesController

    @Spy
    private lateinit var gson: Gson

    private lateinit var favoriteList: MutableList<String>
    private lateinit var favoriteListJson: String

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        favoriteEventController = FavoriteEventControllerImpl(preferencesController, gson)
        favoriteList = mutableListOf("event_1", "event_2")
        favoriteListJson = Gson().toJson(favoriteList)
    }

    @Test
    fun `When getFavorites is called and list is not empty then Success is emitted`() =
        coroutineRule.runTest {
            Mockito.`when`(preferencesController.getString(FAVORITES, ""))
                .thenReturn(favoriteListJson)

            favoriteEventController.getFavorites().runFlowTest {
                assertEquals(FavoriteEventsControllerPartialState.Success(favoriteList), awaitItem())
            }
        }

    @Test
    fun `When getFavorites is called and list is empty then Fail is emitted`() =
        coroutineRule.runTest {
            Mockito.`when`(preferencesController.getString(FAVORITES, ""))
                .thenReturn("")

            favoriteEventController.getFavorites().runFlowTest {
                assertEquals(FavoriteEventsControllerPartialState.Fail(""), awaitItem())
            }
        }

    @Test
    fun `When addFavorite is called with new id then Success is emitted with updated list`() =
        coroutineRule.runTest {
            Mockito.`when`(preferencesController.getString(FAVORITES, ""))
                .thenReturn(favoriteListJson)
            Mockito.`when`(gson.toJson(Mockito.anyList<String>())).thenReturn(favoriteListJson)

            favoriteEventController.addFavorite("event_3").runFlowTest {
                val expected = favoriteList.apply { add("event_3") }
                assertEquals(FavoriteEventsControllerPartialState.Success(expected), awaitItem())
            }
        }

    @Test
    fun `When removeFavorite is called with existing id then Success is emitted with updated list`() =
        coroutineRule.runTest {
            Mockito.`when`(preferencesController.getString(FAVORITES, ""))
                .thenReturn(favoriteListJson)
            Mockito.`when`(gson.toJson(Mockito.anyList<String>())).thenReturn(favoriteListJson)

            favoriteEventController.removeFavorite("event_1").runFlowTest {
                val expected = favoriteList.apply { remove("event_1") }
                assertEquals(FavoriteEventsControllerPartialState.Success(expected), awaitItem())
            }
        }
}
