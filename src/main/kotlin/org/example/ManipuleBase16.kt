package org.example

class ManipuleBase16: CharsNotBase64(), ManipulePrefix {
    override fun manipuleCaracter(payload: Payload): ConvertToDecimal {
        if (payload.num.lowercase().startsWith("0x"))
            payload.num.substring(2)

        return ConvertToDecimal(payload, getChar())
    }
}