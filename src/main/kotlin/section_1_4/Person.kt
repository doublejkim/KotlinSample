package org.example.section_1_4

class Person(name: String, age: Int){
    val name = name
        get() = this.name.uppercase()

}