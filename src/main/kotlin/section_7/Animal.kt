package org.example.section_7

abstract class Animal(
    protected val name: String,
    protected open val legCount: Int, // 코틀린에서는 프로퍼티를 override 를 하려면 open 해줘야함 (추상 프로퍼티가 아니라면..)
) {
    abstract fun speak()
}