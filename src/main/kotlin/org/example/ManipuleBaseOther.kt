package org.example

class ManipuleBaseOther: CharsNotBase64(), ManipulePrefix {
    override fun manipuleCaracter(payload: Payload): ConvertToDecimal {
        val permissionBase = intArrayOf(2,8,16,64)

        if (payload.base in permissionBase)
            return ConvertToDecimal(payload, getChar());

        if ("#" in payload.num) {
            val (sBase, newSNum) = payload.num.split("#", limit = 2)
            payload.base = sBase.toInt()
            newSNum.also { payload.num = it }
        }

        if (payload.base == 0) {
            println("baseBase2Dec called without a base value and not in base#number format")
            return ConvertToDecimal(payload, getChar());
        }

        return ConvertToDecimal(payload, getChar())
    }
}