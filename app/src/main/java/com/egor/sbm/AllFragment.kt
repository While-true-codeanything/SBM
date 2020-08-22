package com.egor.sbm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.list_fragment.*

class AllFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_list_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        val dlist = MemoryAccesser.Data
        var a = 0
        for (i in 0 until dlist.size) {
            a += dlist.get(i).Value
        }
        if (a > 0) {
            total.text = "+" + a
        } else {
            total.text = a.toString()
        }
        list.adapter = ListAdapter(0)
    }
}