package org.example

fun main() {
    println("Hello World!")

    var a: String = ""
    var b: String? = ""

    repeatPrint("Hello", 3 )

}

fun repeatPrint(str: String, count: Int = 3, newLine: Boolean = true) {
    for (i in 1..count) {
        print(str)
        if (newLine) {
            println()
        }
    }
}