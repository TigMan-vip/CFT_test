package com.example.testing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ValuteAdapter(private val valutelist: ArrayList<valuteMoodelClass>): RecyclerView.Adapter<ValuteAdapter.ValuteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)
        return ValuteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ValuteViewHolder, position: Int) {
        val currentItem = valutelist[position]
        holder.id.text = currentItem.ID
        holder.name.text = currentItem.Name
        holder.nominal.text = currentItem.Nominal
        holder.value.text = currentItem.Value.toString()
        holder.numcode.text = currentItem.NumCode
        holder.charcode.text = currentItem.CharCode
    }

    override fun getItemCount() = valutelist.size
    class ValuteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val id: TextView = itemView.ID_valute
        val numcode: TextView = itemView.numcode_valute
        val nominal: TextView = itemView.nominal_valute
        val name: TextView = itemView.name_valute
        val value: TextView = itemView.value_valute
        val charcode: TextView = itemView.charcode_valute
    }
}



