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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.sportsBookApp.core_domain.model.EventDomain
import com.android.sportsBookApp.core_domain.model.SportsEventsDomain
import com.android.sportsBookApp.core_domain.model.provideMockEvents
import com.android.sportsBookApp.core_domain.model.providedMockSports
import com.android.sportsBookApp.core_resources.R
import com.android.sportsBookApp.core_ui.component.MatchCard


@Composable
fun SportHeader(
    title: String,
    isExpanded: Boolean,
    isEnabled: Boolean,
    onFavoriteChanged: (Boolean) -> Unit,
    onExpandClick: (Boolean) -> Unit,
    notifyNotEnabled: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSurface)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.surfaceVariant,
                fontWeight = FontWeight.Bold
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            ToggleSwitch(
                isEnabled = isEnabled,
                onFavoriteChanged = onFavoriteChanged,
                notifyNotEnabled = notifyNotEnabled
            )
            IconButton(onClick = { onExpandClick(isExpanded) }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
    }
}

@Composable
fun ToggleSwitch(
    isEnabled: Boolean,
    onFavoriteChanged: (Boolean) -> Unit = {},
    notifyNotEnabled: () -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }

    val trackColor = when {
        !isEnabled -> MaterialTheme.colorScheme.surfaceVariant
        else -> MaterialTheme.colorScheme.surface
    }

    val thumbColor = when {
        !isEnabled -> MaterialTheme.colorScheme.surfaceVariant
        isChecked -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.tertiary
    }


    Switch(
        checked = isChecked,
        onCheckedChange = {
            if (isEnabled) {
                isChecked = it
                onFavoriteChanged(it)
            } else {
                notifyNotEnabled()
            }
        },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = thumbColor,
            uncheckedThumbColor = thumbColor,
            checkedTrackColor = trackColor,
            uncheckedTrackColor = trackColor
        ),
        thumbContent = {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
                modifier = Modifier.size(SwitchDefaults.IconSize),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SportCompetitions(
    competitions: List<EventDomain>,
    toggleFavoriteEvent: (String, Boolean) -> Unit,
    onEventClick: (EventDomain) -> Unit
) {
    if (competitions.isNotEmpty())
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalArrangement = Arrangement.Start
        ) {
            competitions.forEach { competition ->
                MatchCard(competition, toggleFavoriteEvent, onEventClick)
            }
        }
    else
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(stringResource(R.string.no_sport_events))
        }
}

@Composable
fun MainScreenListItem(
    sport: SportsEventsDomain,
    isEnabled: Boolean,
    expandSportCompetitions: (Boolean) -> Unit,
    toggleFavoriteEvent: (String, Boolean) -> Unit,
    onFavoriteChanged: (Boolean) -> Unit,
    notifyNotEnabled: () -> Unit,
    onItemClick: (EventDomain) -> Unit
) {
    Column {
        SportHeader(
            sport.sportName ?: "",
            isExpanded = sport.isExpanded,
            isEnabled = isEnabled,
            onExpandClick = expandSportCompetitions,
            onFavoriteChanged = onFavoriteChanged,
            notifyNotEnabled = notifyNotEnabled
        )
        AnimatedVisibility(
            visible = sport.isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            sport.activeEvents?.let {
                SportCompetitions(
                    competitions = it,
                    toggleFavoriteEvent,
                    onItemClick
                )
            }
        }
    }
}

@Preview
@Composable
fun MainScreenListPreview() {
    MainScreenListItem(
        sport = providedMockSports()[0],
        isEnabled = true,
        expandSportCompetitions = {},
        onFavoriteChanged = {},
        toggleFavoriteEvent = { _, _ -> },
        notifyNotEnabled = {},
        onItemClick = { _ -> "" }
    )

}

@Preview(showBackground = true, backgroundColor = 0xFF2D2D2D)
@Composable
fun MatchCardPreview() {
    MatchCard(provideMockEvents()[0], { _, _ -> }, onEventClick = { _ -> "" }
    )
}


@Preview(showBackground = true, backgroundColor = 0xFF2D2D2D)
@Composable
fun SportCompetitionsPreview() {
    SportCompetitions(
        competitions = provideMockEvents(),
        toggleFavoriteEvent = { _, _ -> },
        onEventClick = {_->""}
    )
}

@Preview(showBackground = true)
@Composable
fun SportHeaderExpandedPreview() {
    SportHeader(
        "Sport",
        isExpanded = true,
        isEnabled = true,
        onExpandClick = {},
        onFavoriteChanged = {},
        notifyNotEnabled = {})
}

@Preview(showBackground = true)
@Composable
fun SportHeaderNotExpandedPreview() {
    SportHeader(
        "Sport",
        isExpanded = false,
        isEnabled = false,
        onExpandClick = {},
        onFavoriteChanged = { },
        notifyNotEnabled = {}
    )
}

