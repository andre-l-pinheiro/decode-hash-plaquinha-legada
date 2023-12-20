package org.example

import java.math.BigDecimal
import kotlin.math.pow

class ConvertToDecimal(private var payload: Payload? = null, private val chars: String) {

    fun converterToDecimal(): String {
        var result = BigDecimal.ZERO

        payload?.let {
            if (it.base < 37)
                it.num.lowercase()

            if ("." in it.num) {
                val (newSNum, sReal) = it.num.split(".", limit = 2)
                it.num = newSNum
                val real = "0.$sReal"
                result = BigDecimal(real)
            }

            val iLen = it.num.length

            for (i in iLen - 1 downTo 0) {
                val sChar = it.num[i].toString()
                val iValue = chars.indexOf(sChar)
                if (iValue > it.base) {
                    println("baseBase2Dec> ${it.num} is not a valid base ${it.base} number")
                    return "";
                }

                result += BigDecimal(iValue) * it.base.toDouble().pow((iLen - i - 1).toDouble()).toBigDecimal()
            }
        }
        return result.toString()
    }
}
