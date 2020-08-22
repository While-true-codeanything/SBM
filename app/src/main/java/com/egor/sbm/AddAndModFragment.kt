package com.egor.sbm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.nandmod_layout.*

class AddAndModFragment() : Fragment() {
    var isfrmObj: Boolean = false
    var frmObj: DataItem? = null

    constructor(obj: DataItem) : this() {
        isfrmObj = true
        frmObj = obj
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nandmod_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        if (isfrmObj) {
            val curdt = this!!.frmObj!!
            Crname.setText(curdt.Name)
            CrValue.setText(curdt.Value.toString())
            CrDesc.setText(curdt.Descripton)
        }
        close.setOnClickListener {
            (activity as MainActivity).loadFragment(AllFragment())
        }
        save.setOnClickListener {
            val newDt = DataItem(
                CrValue.text.toString().toInt(),
                Crname.text.toString(),
                CrDesc.text.toString()
            )
            val data = MemoryAccesser.Data
            if (isfrmObj) {
                for (i in 0 until data.size) {
                    if (data.get(i).equals(frmObj)) {
                        data.removeAt(i)
                        break
                    }
                }
                data.add(newDt)
                MemoryAccesser(context!!).setData(data)
            } else {
                data.add(newDt)
                MemoryAccesser(context!!).setData(data)
            }
            (activity as MainActivity).loadFragment(AllFragment())
        }
    }
}