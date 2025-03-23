package org.example.section_1_4

class Person(
    val name: String,
    _age: Int
){

    val field = name
        get() = field.uppercase()

    internal fun internalTest(str: String) {
        println("Hello $str")
    }

    var age = _age
        private set

}