package org.example.section_11

fun main() {

    // 리스트 사용하기
    val numbers1 = listOf(10, 20)
    val numbers2 = mutableListOf(10, 20)
    numbers2.add(30)
    val emptyList1 = emptyList<String>()

    for (number in numbers1) {
        println(number)
    }

    for ((idx, value) in numbers2.withIndex()) {
        println("$idx: $value")
    }

    val lists = mutableListOf<String>()
    lists.add("aaa")
    lists.add("bbb")

    for (value in lists) {
        println(value)
    }

    // 셋 사용하기
    val setNumbers = setOf(10, 20)
    for (number in setNumbers) {
        println(number) // list 사용 법은 동일
    }

    // 맵 사용하기
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "AAA" // java 처럼 put 을 사용해도 됨
    oldMap[2] = "BBB"

    for (key in oldMap.keys) {
        println("$key: $oldMap[$key]")
    }

    val newMap = mapOf(1 to "XXX", 2 to "YYY", 3 to "ZZZ")

    for ((key, value) in newMap) { // .entries?
        println("$key: $value")
    }

}