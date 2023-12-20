package org.example

class ManipuleBaseFactory(var payload: Payload): BaseFactory {
    override fun createBase(): ConvertToDecimal {
        return when (payload.base) {
            64 -> ManipuleBase64().manipuleCaracter(payload)
            16 -> ManipuleBase16().manipuleCaracter(payload)
            8 -> ManipuleBase8().manipuleCaracter(payload)
            2 -> ManipuleBase2().manipuleCaracter(payload)
            else -> ManipuleBaseOther().manipuleCaracter(payload)
        }
    }
}