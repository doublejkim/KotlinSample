package org.example.section_13

import section_13.JavaFood
import java.io.BufferedReader
import java.io.FileReader

fun main() {

    val foods = listOf(
        JavaFood("돈까스", 1_000),
        JavaFood("돈까스", 5_500),
        JavaFood("국수", 2_000),
        JavaFood("국수", 2_500),
        JavaFood("국수", 3_500),
        JavaFood("스테이크", 20_000)
    )

    val isDon1 = fun (food: JavaFood): Boolean {
        return food.name == "돈까스"
    }

    val isDon2 = { food: JavaFood -> food.name == "돈까스" }

    println(isDon1(foods[0]))
    println(isDon2.invoke(foods[2]))

    println("====================================")

    // 람다를 파라미터로 전달할수있음
    val noodles = filterFoods(foods, { food: JavaFood -> food.name == "국수" })
    noodles.forEach { println(it) }

    println("====================================")

    // 만약 람다형태로 받는 함수의 파라미터가 , 파라미터의 순서중 가장마지막에 있다면
    // 소괄호 밖으로 빼서 사용할수있도록 허용
    val luxuryFoods = filterFoods(foods) { food: JavaFood -> food.price > 5_000 }
    luxuryFoods.forEach { println(it) }

    println("====================================")

    // filterFoods() 함수의 파라미터에 타입이 존재하기때문에 컴파일러가 호출하는쪽에서 타입으 추론할수있어서 타입생략 가능
    val donFoods = filterFoods(foods) { food -> food.name == "돈까스"}
    donFoods.forEach { println(it) }

    println("====================================")
    // 만약 람다로 표현할때 파라미터가 1개라면 it 이라는 키워드를 사용할수있음
    val steakFoods = filterFoods(foods) { it.name == "스테이크 "}
    donFoods.forEach { println(it) }



}

fun filterFoods(
    foods: List<JavaFood>,
    filter: (JavaFood) -> Boolean,
): List<JavaFood> {
    val results = mutableListOf<JavaFood>()
    for (food in foods) {
        if (filter(food)) {
            results.add(food)
        }
    }
    return results
}

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { br ->
        println(br.readLine())
    }
}