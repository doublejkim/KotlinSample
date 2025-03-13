package org.example.section_7

class Dog(
    name: String
) : Animal(name, 4) {

    override fun speak() { println("멍멍")  }

}