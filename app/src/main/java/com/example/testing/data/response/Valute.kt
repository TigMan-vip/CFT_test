package com.example.testing.data.response


import com.google.gson.annotations.SerializedName

data class Valute(
    @SerializedName("AMD")
    val aMD: AMD,
    @SerializedName("AUD")
    val aUD: AUD,
    @SerializedName("AZN")
    val aZN: AZN,
    @SerializedName("BGN")
    val bGN: BGN,
    @SerializedName("BRL")
    val bRL: BRL,
    @SerializedName("BYN")
    val bYN: BYN,
    @SerializedName("CAD")
    val cAD: CAD,
    @SerializedName("CHF")
    val cHF: CHF,
    @SerializedName("CNY")
    val cNY: CNY,
    @SerializedName("CZK")
    val cZK: CZK,
    @SerializedName("DKK")
    val dKK: DKK,
    @SerializedName("EUR")
    val eUR: EUR,
    @SerializedName("GBP")
    val gBP: GBP,
    @SerializedName("HKD")
    val hKD: HKD,
    @SerializedName("HUF")
    val hUF: HUF,
    @SerializedName("INR")
    val iNR: INR,
    @SerializedName("JPY")
    val jPY: JPY,
    @SerializedName("KGS")
    val kGS: KGS,
    @SerializedName("KRW")
    val kRW: KRW,
    @SerializedName("KZT")
    val kZT: KZT,
    @SerializedName("MDL")
    val mDL: MDL,
    @SerializedName("NOK")
    val nOK: NOK,
    @SerializedName("PLN")
    val pLN: PLN,
    @SerializedName("RON")
    val rON: RON,
    @SerializedName("SEK")
    val sEK: SEK,
    @SerializedName("SGD")
    val sGD: SGD,
    @SerializedName("TJS")
    val tJS: TJS,
    @SerializedName("TMT")
    val tMT: TMT,
    @SerializedName("TRY")
    val tRY: TRY,
    @SerializedName("UAH")
    val uAH: UAH,
    @SerializedName("USD")
    val uSD: USD,
    @SerializedName("UZS")
    val uZS: UZS,
    @SerializedName("XDR")
    val xDR: XDR,
    @SerializedName("ZAR")
    val zAR: ZAR
)