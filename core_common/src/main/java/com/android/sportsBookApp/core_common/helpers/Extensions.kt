package com.android.sportsBookApp.core_common.helpers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

val serverDateParseFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
val dateTimeDisplayFormatter = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US)
val sessionDialogServerTimeFormatter = SimpleDateFormat("MM/dd/yyyy hh:mm", Locale.US)

fun <T> Flow<T>.safeAsync(with: (Throwable) -> (T)): Flow<T> {
    return this.flowOn(Dispatchers.IO).catch { emit(with(it)) }
}



//// Format seconds to HH:mm:ss
// fun  Long.formatTime(): String {
//    val h = TimeUnit.SECONDS.toHours(this)
//    val m = TimeUnit.SECONDS.toMinutes(this) % 60
//    val s = this % 60
//    return String.format("%02d:%02d:%02d", h, m, s)
//}

 fun Int.formatTime(): String {
    val h = this / 3600
    val m = (this % 3600) / 60
    val s = this % 60
    return String.format("%02d:%02d:%02d", h, m, s)
}
