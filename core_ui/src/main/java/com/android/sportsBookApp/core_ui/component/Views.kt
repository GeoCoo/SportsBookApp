package com.android.sportsBookApp.core_ui.component


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.android.sportsBookApp.core_domain.model.EventDomain
import kotlinx.coroutines.delay

/**
 * Execute an effect based on [Lifecycle.Event]
 *
 *  @param lifecycleOwner The lifecycle owner
 *  @param lifecycleEvent The lifecycle event that code needs to be executed
 */
@Composable
fun LifecycleEffect(
    lifecycleOwner: LifecycleOwner, lifecycleEvent: Lifecycle.Event, block: () -> Unit,
) {
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == lifecycleEvent) {
                block()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

@Composable
fun CountdownTimer(eventDate: Int) {
    val targetMillis = remember(eventDate) { eventDate.toLong() * 1000 }
    var currentTimeMillis by remember { mutableLongStateOf(System.currentTimeMillis()) }

    LaunchedEffect(targetMillis) {
        while (currentTimeMillis < targetMillis) {
            delay(1000)
            currentTimeMillis = System.currentTimeMillis()
        }
    }

    val remainingMillis = (targetMillis - currentTimeMillis).coerceAtLeast(0)
    val formattedTime = formatMillisToHHMMSS(remainingMillis)

    Text(
        text = formattedTime,
        fontSize = 12.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 2.dp)
    )
}

@Composable
private fun formatMillisToHHMMSS(millis: Long): String {
    val totalSeconds = millis / 1000
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60
    return "%02d:%02d:%02d".format(hours, minutes, seconds)
}


@Composable
fun FavoriteIcon(isFavorite: Boolean, eventId: String, toggleFavoriteEvent: (String, Boolean) -> Unit) {
    IconButton(onClick = { toggleFavoriteEvent(eventId,isFavorite) }) {
        Icon(
            imageVector = if (isFavorite) Icons.Filled.Star else Icons.Outlined.Star,
            contentDescription = "Favorite",
            tint = if (isFavorite) MaterialTheme.colorScheme.primary else Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun CompetitorsView(competitors: Pair<String, String>?) {
    Text(
        text = competitors?.first ?: "",
        color = Color.White,
        fontSize = 12.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

    Text(
        text = "vs",
        color = Color.Red,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = competitors?.second ?: "",
        color = Color.White,
        fontSize = 12.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MatchCard(
    competition: EventDomain,
    toggleFavoriteEvent: (String, Boolean) -> Unit,
    onEventClick: (EventDomain) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onEventClick(competition) })
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

