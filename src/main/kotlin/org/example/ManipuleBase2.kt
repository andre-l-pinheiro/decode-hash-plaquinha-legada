package org.example

class ManipuleBase2(): CharsNotBase64(), ManipulePrefix {
    override fun manipuleCaracter(payload: Payload): ConvertToDecimal {
        if (payload.num.lowercase().startsWith("0b"))
            payload.num.substring(2)

        return ConvertToDecimal(payload, getChar())
    }
}