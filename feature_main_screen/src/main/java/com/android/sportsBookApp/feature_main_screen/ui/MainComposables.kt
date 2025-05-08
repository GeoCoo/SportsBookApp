package com.android.sportsBookApp.feature_main_screen.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.sportsBookApp.core_domain.model.EventDomain
import com.android.sportsBookApp.core_domain.model.SportsEventsDomain
import com.android.sportsBookApp.core_domain.model.provideMockEvents
import com.android.sportsBookApp.core_domain.model.proviedMockSports
import com.android.sportsBookApp.core_ui.component.CompetitorsView
import com.android.sportsBookApp.core_ui.component.CountdownTimer
import com.android.sportsBookApp.core_ui.component.FavoriteIcon


@Composable
fun MatchCard(competition: EventDomain, toggleFavoriteEvent: (String, Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp / 2 - 16.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        CountdownTimer(competition.eventStartTime)
        FavoriteIcon(competition.isFavorite, competition.eventId, toggleFavoriteEvent)
        CompetitorsView(competition.competitors)
    }
}


@Composable
fun SportHeader(
    title: String,
    showFavorites: Boolean = false,
    isExpanded: Boolean,
    onFavoriteChanged: (Boolean) -> Unit = {},
    onExpandClick: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left section: Red dot and "SPORT"
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD84315)) // Deep orange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Right section: Favorite toggle + arrow icon
        Row(verticalAlignment = Alignment.CenterVertically) {
            var isChecked by remember { mutableStateOf(showFavorites) }

            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    onFavoriteChanged(it)
                },
                thumbContent = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorite",
                        modifier = Modifier.size(SwitchDefaults.IconSize)
                    )
                }
            )

            IconButton(onClick = { onExpandClick.invoke(isExpanded) }) {
                Icon(
                    tint = Color.Black,
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Collapse"
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SportCompetitions(
    competitions: List<EventDomain>,
    toggleFavoriteEvent: (String, Boolean) -> Unit
) {

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalArrangement = Arrangement.Start
    ) {
        competitions.forEach { competition ->
            MatchCard(competition, toggleFavoriteEvent)
        }
    }
}

@Composable
fun MainScreenListItem(
    sport: SportsEventsDomain,
    expandSportCompetitions: (Boolean) -> Unit,
    toggleFavoriteEvent: (String, Boolean) -> Unit
) {
    Column {
        SportHeader(
            sport.sportName ?: "",
            showFavorites = sport.hasFavoritess,
            isExpanded = sport.isExpanded,
            onExpandClick = expandSportCompetitions
        )
        AnimatedVisibility(
            visible = sport.isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            SportCompetitions(competitions = sport.activeEvents, toggleFavoriteEvent)
        }
    }
}

@Preview
@Composable
fun MainScreenListPreview() {
    MainScreenListItem(sport = proviedMockSports()[0], {}, { _,_ -> }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF2D2D2D)
@Composable
fun MatchCardPreview() {
    MatchCard(provideMockEvents()[0], {_,_->})
}


@Preview(showBackground = true, backgroundColor = 0xFF2D2D2D)
@Composable
fun SportCompetitionsPreview() {
    SportCompetitions(competitions = provideMockEvents(), { _, _ -> })
}

@Preview(showBackground = true)
@Composable
fun SportHeaderExpandedPreview() {
    SportHeader("Sport", isExpanded = true, onExpandClick = {})
}

@Preview(showBackground = true)
@Composable
fun SportHeaderNotExpandedPreview() {
    SportHeader("Sport", isExpanded = false, onExpandClick = {})
}

@Preview(showBackground = true)
@Composable
fun SportHeaderHasFavoritesPreview() {
    SportHeader("Sport", isExpanded = false, onExpandClick = {}, showFavorites = true)
}

@Preview(showBackground = true)
@Composable
fun SportHeaderHasNotFavoritesPreview() {
    SportHeader("Sport", isExpanded = false, onExpandClick = {}, showFavorites = false)
}


