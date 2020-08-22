package com.egor.sbm

import java.text.SimpleDateFormat
import java.util.*

class DataItem(Value2: Int, Name2: String, Descripton2: String) {
    var Value: Int
    var Name: String
    var Time: String
    var Descripton: String

    init {
        Value = Value2
        Name = Name2
        val formatForDateNow =
            SimpleDateFormat("dd.MM.yyyy")
        Time = formatForDateNow.format(Date())
        Descripton = Descripton2
    }
}