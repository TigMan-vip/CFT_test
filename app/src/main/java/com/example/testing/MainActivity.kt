package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.json.JSONObject
import java.lang.Runnable
import java.net.URL
import kotlin.concurrent.thread


val valuteList: ArrayList<valuteMoodelClass> = ArrayList()

class MainActivity : AppCompatActivity(), ValuteAdapter.OnItemsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            while (true) {
                getJson() //Функия заполнения ArrayList соответствующими данными
                withContext(Dispatchers.Main) {
                    recycler_view.adapter = ValuteAdapter(valuteList, this@MainActivity)
                    recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
                    Toast.makeText(applicationContext, "Список обновлен", Toast.LENGTH_SHORT).show()
                    delay(180000)
                }
            }
        }
    }

    override fun onItemClick(position: Int) {
        val clicedItem = valuteList[position]
        CharCodeResult.text = clicedItem.CharCode
        try {
            if(IDeditTextDate.text[0] == '0'){
                throw Exception()
            }
            else {
                var ConvertValute = IDeditTextDate.text.toString()
                    .toDouble() / (clicedItem.Value / clicedItem.Nominal.toDouble())
                textViewResult.text = String.format("%.3f", ConvertValute).toString()
            }
        }catch (e:Exception){
            Toast.makeText(applicationContext, "Введите корректное значение!!",Toast.LENGTH_SHORT).show()}
    }

    fun getJson() {
        valuteList.clear()
        val valuteName: Array<String> = arrayOf("AUD", "AZN", "GBP", "AMD","BYN",
            "BGN","BRL","HUF","HKD","DKK", "USD","EUR", "INR","KZT","CAD","KGS",
            "CNY","MDL","NOK", "PLN","RON","XDR", "SGD","TJS","TRY","TMT","UZS",
            "UAH", "CZK", "SEK","CHF","ZAR","KRW","JPY")

        val url = "https://www.cbr-xml-daily.ru/daily_json.js"
        val jsonText = URL(url).readText() // Записываем содержимое страницы в виде текста в переменную
        val obj = JSONObject(jsonText) // Превращаем текст в JSONObject, чтобы в дальшейщем получать отдельные блоки JSONOject
        val valute = obj.getJSONObject("Valute")

        for(i in 0..(valuteName.size - 1))
        {
            val valObj = valute.getJSONObject(valuteName[i]) //Пробегаемся по блокам JSONObject
            val id = valObj.getString("ID")
            val numCod = valObj.getString("NumCode")
            val charCode = valObj.getString("CharCode")
            val nominal = valObj.getString("Nominal")
            val name = valObj.getString("Name")
            val value = valObj.getDouble("Value")
            val previous = valObj.getDouble("Previous")
            val valuteDetails = valuteMoodelClass(id, numCod, charCode, nominal, name, value, previous)
            valuteList.add(valuteDetails) //Записываем Класс с параметрами в ArrayList
        }
    }

}


