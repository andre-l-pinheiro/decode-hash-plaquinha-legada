package org.example

fun main() {
    loadData()
        .stream()
        .forEach{
            val payload = Payload(it, 64)
            val result = ManipuleBaseFactory(payload).createBase().converterToDecimal()
            println("Elemento: $it e resultado: $result")
        }
}

fun loadData(): List<String> {
    return listOf("xzRj", "DMa4E", "xvnh", "DMbBa", "DMUEK", "yDl*", "DLwGH", "DMa4U", "DMadK", "BMym", "DMMsF")
}