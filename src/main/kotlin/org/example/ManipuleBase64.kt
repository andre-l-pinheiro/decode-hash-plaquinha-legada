package org.example

class ManipuleBase64: CharsBase64(), ManipulePrefix {
    override fun manipuleCaracter(payload: Payload): ConvertToDecimal {
        payload.num.replace("=", "")

        return ConvertToDecimal(payload, getChar())
    }
}