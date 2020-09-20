package com.example.firstkotlinexample.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Note(
    val id: String = "",
    val title: String = "",
    val text: String = "",
    val color: Color = Color.WHITE,
    val lastChanged: Date = Date()
) : Parcelable

enum class Color {
    WHITE,
    YELLOW,
    GREEN,
    BLUE,
    RED,
    VIOLET;
}

fun getRandomColor(): Color {
    val pick = Random().nextInt(Color.values().size)
    return Color.values()[pick]
}