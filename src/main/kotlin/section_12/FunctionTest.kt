package org.example.section_12

fun main() {

    val obj1: Animal = Animal("동물", "뭐라짖을까?")
    obj1.testBark()

    val obj2: Animal = Dog("리트리버", "멍멍")
    obj2.testBark()

    val obj3: Dog = Dog("치와와", "왈왈")
    obj3.testBark()

}

fun String.lastChar(): Char {
    return this[this.length - 1]
}

open class Animal(
    val name: String,
    val bark: String,
)

fun Animal.testBark() {
    println("Animal testBark : $name is $bark")
}

class Dog(name: String, bark: String) : Animal(name, bark)

fun Dog.testBark() {
    println("Dog testBark : $name is $bark")
}