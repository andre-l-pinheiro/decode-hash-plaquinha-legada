package org.example

class ManipuleBase8: CharsNotBase64(), ManipulePrefix {
    override fun manipuleCaracter(payload: Payload): ConvertToDecimal {
        if (payload.num.startsWith("0"))
            payload.num.substring(1)

        return ConvertToDecimal(payload, getChar())
    }
}