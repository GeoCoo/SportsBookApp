package com.android.sportsBookApp.feature_main_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.sportsBookApp.core_model.EventDomain
import com.android.sportsBookApp.core_model.SportsEventsDomain
import com.android.sportsBookApp.core_model.provideMockEvents
import com.android.sportsBookApp.core_model.proviedMockSports
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit


@Composable
fun MatchCard(
    event: EventDomain // 1 hour countdown by default
) {
    var timeLeft by remember { mutableStateOf(event.eventStartTime) }

    // Countdown effect
    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000)
            timeLeft -= 1
        }
    }

    val formattedTime = formatTime(timeLeft.toLong())

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2D2D2D)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = formattedTime,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Favorite",
                tint = Color.LightGray,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = event.competitors?.first ?:"",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "vs",
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = event.competitors?.second ?: "",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

// Format seconds to HH:mm:ss
private fun formatTime(seconds: Long): String {
    val h = TimeUnit.SECONDS.toHours(seconds)
    val m = TimeUnit.SECONDS.toMinutes(seconds) % 60
    val s = seconds % 60
    return String.format("%02d:%02d:%02d", h, m, s)
}

@Composable
fun SportHeader(
    title: String,
    isFavorite: Boolean = false,
    onFavoriteChanged: (Boolean) -> Unit = {},
    onExpandClick: () -> Unit = {}
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
            var isChecked by remember { mutableStateOf(isFavorite) }

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

            IconButton(onClick = onExpandClick) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Collapse"
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SportCompetitions(competitions: List<EventDomain>){
    FlowRow(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        competitions.forEach {comppetition->
            MatchCard(comppetition)
        }
    }
}

@Composable
fun MainScreenListItem(sport:SportsEventsDomain){
    Column {
        SportHeader(sport.sportName ?: "")
        SportCompetitions(competitions = sport.activeEvents)

    }
}

@Preview
@Composable
fun MainScreenListPreview(){
    MainScreenListItem(sport = proviedMockSports()[0])
}


@Preview(showBackground = true)
@Composable
fun SportCompetitionsPreview() {
    SportCompetitions(competitions = provideMockEvents())
}

@Preview(showBackground = true)
@Composable
fun SportHeaderPreview() {
    SportHeader("Sport")
}

@Preview(showBackground = true, backgroundColor = 0xFF2D2D2D)
@Composable
fun MatchCardPreview() {
    MatchCard(provideMockEvents()[0])
}