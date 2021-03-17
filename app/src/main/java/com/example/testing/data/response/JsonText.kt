package com.example.testing.data.response


import android.widget.ListView
import com.google.gson.annotations.SerializedName

data class JsonText(
    @SerializedName("Date")
    val date: String,
    @SerializedName("PreviousDate")
    val previousDate: String,
    @SerializedName("PreviousURL")
    val previousURL: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @SerializedName("Valute")
    val valute: Valute
)
