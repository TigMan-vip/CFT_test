package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL


val valuteList: ArrayList<valuteMoodelClass> = ArrayList()

class MainActivity : AppCompatActivity(), ValuteAdapter.OnItemsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            getJson()
            withContext(Dispatchers.Main){
                recycler_view.adapter = ValuteAdapter(valuteList, this@MainActivity)
                recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    override fun onItemClick(position: Int) {
        val clicedItem = valuteList[position]
        CharCodeResult.text = clicedItem.CharCode
        var a = IDeditTextDate.text.toString().toDouble()/(clicedItem.Value/clicedItem.Nominal.toDouble())
        textViewResult.text = String.format("%.3f",a).toString()
    }
}



fun getJson() {
    val valuteName: Array<String> = arrayOf("AUD", "AZN", "GBP", "AMD","BYN",
        "BGN","BRL","HUF","HKD","DKK", "USD","EUR", "INR","KZT","CAD","KGS",
        "CNY","MDL","NOK", "PLN","RON","XDR", "SGD","TJS","TRY","TMT","UZS",
        "UAH", "CZK", "SEK","CHF","ZAR","KRW","JPY")
    val url = "https://www.cbr-xml-daily.ru/daily_json.js"
    val jsonText = URL(url).readText()
    val obj = JSONObject(jsonText)
    val valute = obj.getJSONObject("Valute")
    for(i in 0..(valuteName.size - 1))
    {
        val valObj = valute.getJSONObject(valuteName[i])
        val id = valObj.getString("ID")
        val numCod = valObj.getString("NumCode")
        val charCode = valObj.getString("CharCode")
        val nominal = valObj.getString("Nominal")
        val name = valObj.getString("Name")
        val value = valObj.getDouble("Value")
        val previous = valObj.getDouble("Previous")
        val valuteDetails = valuteMoodelClass(id, numCod, charCode, nominal, name, value, previous)
        valuteList.add(valuteDetails)
    }
}