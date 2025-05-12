package com.android.sportsBookApp.core_tests.viewModel

import com.android.sportsBookApp.core_domain.model.EventDomain
import com.android.sportsBookApp.core_domain.model.SingleEventDomain
import com.android.sportsBookApp.core_tests.CoroutineTestRule
import com.android.sportsBookApp.core_tests.RobolectricTest
import com.android.sportsBookApp.core_tests.runFlowTest
import com.android.sportsBookApp.core_tests.runTest
import com.android.sportsBookApp.feature_single_event.ui.Event
import com.android.sportsBookApp.feature_single_event.ui.State
import com.android.sportsBookApp.feature_single_event.ui.SingleEventVIewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TestSingleEventViewModel : RobolectricTest() {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    private lateinit var viewModel: SingleEventVIewModel
    private val initialState = State(isLoading = true)

    @Before
    fun setup() {
        viewModel = SingleEventVIewModel()
    }

    @Test
    fun `Given HandleEvent with SingleEventDomain, Then state updates with event and sportName`() =
        coroutineRule.runTest {
            // Arrange
            val mockEvent = EventDomain(
                eventName = "Match 1",
                eventId = "evt001",
                competitors = "A" to "B",
                sportId = "football",
                eventStartTime = 1715100000,
                isFavorite = true
            )

            val singleEvent = SingleEventDomain(
                sportName = "Football",
                event = mockEvent
            )

            // Act
            viewModel.setEvent(Event.HandleEvent(singleEvent))

            // Assert
            viewModel.viewStateHistory.runFlowTest {
                assertEquals(
                    awaitItem(), initialState.copy(
                        isLoading = false,
                        sportName = "Football",
                        event = mockEvent
                    )
                )
            }
        }
}
