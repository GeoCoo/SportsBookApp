package com.android.sportsBookApp.core_common.helpers

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


fun <T> Flow<T>.safeAsync(with: (Throwable) -> (T)): Flow<T> {
    return this.flowOn(Dispatchers.IO).catch { emit(with(it)) }
}

fun String?.splitToPairByDash(): Pair<String, String>? {
    if (this.isNullOrEmpty()) return null

    val parts = this.split("-")
    return if (parts.size == 2) {
        parts[0].trim() to parts[1].trim()
    } else {
        null
    }
}


inline fun <reified T> T.serialize(gson: Gson): String =
    URLEncoder.encode(gson.toJson(this), StandardCharsets.UTF_8.toString())

inline fun <reified T> String.deserialize(gson: Gson): T =
    gson.fromJson(this, T::class.java)
