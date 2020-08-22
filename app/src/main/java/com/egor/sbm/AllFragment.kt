package com.egor.sbm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.all_list_fragment.*
import kotlinx.android.synthetic.main.list_fragment.list
import kotlinx.android.synthetic.main.list_fragment.total

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
            total.setTextColor(resources.getColor(R.color.Green))
            total.background = activity!!.resources.getDrawable(R.drawable.backgreen)
        } else {
            total.text = a.toString()
            total.setTextColor(resources.getColor(R.color.Red))
            total.background = activity!!.resources.getDrawable(R.drawable.backred)
        }
        create.setOnClickListener {
            (activity as MainActivity).loadFragment(AddAndModFragment())
        }
        list.adapter = ListAdapter(0, activity as MainActivity)
    }
}