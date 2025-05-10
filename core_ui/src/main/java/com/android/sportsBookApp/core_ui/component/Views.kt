package com.android.sportsBookApp.core_ui.component


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.android.sportsBookApp.core_common.helpers.formatTime
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
fun CountdownTimer(
    initialSeconds: Int,
    modifier: Modifier = Modifier
) {
    var timeLeft by remember { mutableIntStateOf(initialSeconds) }

    LaunchedEffect(key1 = Unit) {
        while (timeLeft > 0) {
            delay(1000)
            timeLeft--
        }
    }

    val formattedTime = timeLeft.formatTime()

    Text(
        text = formattedTime,
        fontSize = 12.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 2.dp)
    )
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
