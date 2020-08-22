package com.egor.sbm

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import org.json.JSONObject


class MemoryAccesser(ct: Context) {
    companion object {
        val List = "DtList"
        val File = "Dta"
        var Loaded = false
        lateinit var Data: ArrayList<DataItem>
    }

    lateinit var accesser: SharedPreferences

    init {
        try {
            accesser = ct.getSharedPreferences(
                File,
                Context.MODE_PRIVATE
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        if (!Loaded) {
            Loaded = true
            getData()
        }
    }

    fun setData(data: ArrayList<DataItem>) {
        val editor: SharedPreferences.Editor = accesser.edit()
        val converter = Gson()
        val json: String = converter.toJson(DataBlank(data))
        editor.putString(List, json)
        editor.apply()
        getData()
    }

    fun getData() {
        val gson = Gson()
        if (accesser.contains(List)) {
            val json: String = accesser.getString(List, "").toString()
            val object2 = JSONObject(json)
            val list: ArrayList<DataItem> =
                gson.fromJson(object2.toString(), DataBlank::class.java).Data
            Data = list
        } else Data = ArrayList()
    }
}