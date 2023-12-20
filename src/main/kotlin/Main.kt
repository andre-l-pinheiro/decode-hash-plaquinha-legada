package org.example

import java.math.BigDecimal
import kotlin.math.pow


fun main() {
    val payload = Payload("yCYv", 64)
    val result = ManipuleBaseFactory(payload).createBase().converterToDecimal();
    println(result)
}

fun base64Execute() {
    println("Executar em base 64")

    val result1 = baseBase2Dec("DLZvS", 64)
    val result2 = baseBase2Dec("DL6dA", 64)
    val result3 = baseBase2Dec("x,R0", 64)
    val result4 = baseBase2Dec("DL8bn", 64)
    val result5 = baseBase2Dec("x5FK", 64)
    println(result1)
    println(result2)
    println(result3)
    println(result4)
    println(result5)
}

fun baseBase2Dec(sNum: String, iBase: Int = 0, iScale: Int = 0): String {
    var sChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    var sResult = BigDecimal.ZERO

    var base = iBase

    if (base == 64)
        sChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*,"

    when (base) {
        16 -> {
            if (sNum.lowercase().startsWith("0x"))
                sNum.substring(2)
        }
        8 -> {
            if (sNum.startsWith("0"))
                sNum.substring(1)
        }
        2 -> {
            if (sNum.lowercase().startsWith("0b"))
                sNum.substring(2)
        }
        64 -> {
            sNum.replace("=", "")
        }
        else -> {
            var sNum = sNum

            if ("#" in sNum) {
                val (sBase, newSNum) = sNum.split("#", limit = 2)
                base = sBase.toInt()
                newSNum.also { sNum = it }
            }

            if (base == 0) {
                println("baseBase2Dec called without a base value and not in base#number format")
                return ""
            }
        }
    }

    var sNum = sNum

    if (base < 37) sNum = sNum.lowercase()

    if ("." in sNum) {
        val (newSNum, sReal) = sNum.split(".", limit = 2)
        sNum = newSNum
        val real = "0.$sReal"
        sResult += BigDecimal(real)
    }

    val iLen = sNum.length

    for (i in iLen - 1 downTo 0) {
        val sChar = sNum[i].toString()
        val iValue = sChars.indexOf(sChar)
        if (iValue > base) {
            println("baseBase2Dec> $sNum is not a valid base $base number")
            return ""
        }

        sResult += BigDecimal(iValue) * base.toDouble().pow((iLen - i - 1).toDouble()).toBigDecimal()
    }

    return sResult.toString()
}
