package org.example

open class CharsBase64: Chars {
    override fun getChar(): String {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*,"
    }
}