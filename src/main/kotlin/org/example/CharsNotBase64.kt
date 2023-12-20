package org.example

open class CharsNotBase64: Chars {
    override fun getChar(): String {
        return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    }
}