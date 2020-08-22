package com.egor.sbm

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment(var type: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        val dlist = MemoryAccesser.Data
        var a = 0
        if (type == 1) {
            for (i in 0 until dlist.size) {
                if (dlist.get(i).Value > 0) {
                    a += dlist.get(i).Value
                }
            }
        } else {
            for (i in 0 until dlist.size) {
                if (dlist.get(i).Value < 0) {
                    a += dlist.get(i).Value
                }
            }
        }
        if (a > 0) {
            total.text = "+" + a
            total.setTextColor(resources.getColor(R.color.Green))
        } else {
            total.text = a.toString()
            total.setTextColor(resources.getColor(R.color.Red))
        }
        list.adapter = ListAdapter(type, activity as Activity)
    }
}