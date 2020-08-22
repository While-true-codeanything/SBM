package com.egor.sbm

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.gson.Gson

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
            val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            accesser = ct.getSharedPreferences(
                File,
                Context.MODE_PRIVATE
            )
            accesser = EncryptedSharedPreferences.create(
                File,
                masterKeyAlias,
                ct,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        if (!Loaded) {
            Data = getData()
            Loaded = true
        }
    }

    fun setData(data: ArrayList<DataItem>) {
        val editor: SharedPreferences.Editor = accesser.edit()
        val converter = Gson()
        val json: String = converter.toJson(data)
        editor.putString(List, json)
        editor.apply()
    }

    fun getData(): ArrayList<DataItem> {
        val gson = Gson()
        if (accesser.contains(List)) {
            val json: String = accesser.getString(List, "").toString()
            val list: ArrayList<DataItem> =
                gson.fromJson<ArrayList<DataItem>>(json, DataItem::class.java)
            return list
        } else return ArrayList()
    }
}