package com.egor.sbm

import java.text.SimpleDateFormat
import java.util.*

class DataItem(var Value2: Int, var Name2: String) {
    var Value: Int
    var Name: String
    var Time: String

    init {
        Value = Value2
        Name = Name2
        val formatForDateNow =
            SimpleDateFormat("dd.MM.yyyy")
        Time = formatForDateNow.format(Date())
    }
}