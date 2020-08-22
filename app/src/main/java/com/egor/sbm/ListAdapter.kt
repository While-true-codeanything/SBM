package com.egor.sbm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_item.view.*

class ListAdapter(var type: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: ArrayList<DataItem>

    init {
        list = MemoryAccesser.Data
        when (type) {
            1 -> {
                val a = ArrayList<DataItem>()
                for (i in 0 until list.size) {
                    if (list.get(i).Value > 0) {
                        a.add(list.get(i))
                    }
                }
                list = a
            }
            2 -> {
                val a = ArrayList<DataItem>()
                for (i in 0 until list.size) {
                    if (list.get(i).Value < 0) {
                        a.add(list.get(i))
                    }
                }
                list = a
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.data_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as ItemHolder
        holder.name.text = list.get(position).Name
        holder.time.text = list.get(position).Time
        holder.value.text = list.get(position).Value.toString()
    }

    inner class ItemHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val name = root.name
        val time = root.time
        val value = root.value
    }
}