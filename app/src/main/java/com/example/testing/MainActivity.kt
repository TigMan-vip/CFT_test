package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.data.ApiService
import com.example.testing.data.response.JsonText
import com.google.gson.JsonObject
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL


const val BASE_URL = "https://www.cbr-xml-daily.ru/"
lateinit var valy: String

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        GlobalScope.launch(Dispatchers.IO) {
            val response = getRetrofit().getValuteInf().execute()
            val data: JsonText = response.body()!!

                    Log.d("MyLog", "${data.valute.aMD}")
        }

    }
}

fun getRetrofit(): ApiService {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}

/*fun getJson() {
    val valuteList: ArrayList<valuteMoodelClass> = ArrayList()
    val valuteName: Array<String> = arrayOf("AUD", "AZN", "GBP", "AMD", "AMD","BYN")
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
    Log.d("MyLog", "${valuteList.get(0)}")
}*/