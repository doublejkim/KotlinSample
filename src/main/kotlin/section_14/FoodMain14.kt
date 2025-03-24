package org.example.section_14

/**
 *
 *
 * @author felix / jaejin83.kim@dreamus.io
 * @since  2025/03/24
 */
fun main() {

	val foods = listOf(
		Food(1, "라면", 3_000),
		Food(2, "라면", 4_500),
		Food(3, "김밥", 2_000),
		Food(4, "김밥", 2_500),
		Food(5, "어묵", 2_000),
		Food(6, "탕수육", 10_000),
		Food(7, "탕수육", 15_000),
	)

	println("======================================= 필터")
	val ramens = foods.filter { food -> food.name == "라면" }
	ramens.forEach { println(it) }

	println("======================================= 필터에서 인덱스 사용")
	val filterIndexed = foods.filterIndexed { idx, fruit ->
		println("idx: $idx, fruit: $fruit")
		fruit.name == "김밥"
	}
	filterIndexed.forEach { println(it) }

	println("======================================= 필터링 후 매핑")
	val expensiveFoods1 = foods.filter { fruit -> fruit.price > 5_000 }
		.map { fruit -> fruit.name }
	expensiveFoods1.forEach { println(it) }

	println("======================================= all ")
	println(foods.all { it.price > 3_000 } ) // 모든 요소가 조건을 만족 : true

	println("======================================= none ")
	println(foods.none { it.price > 20_000 } ) // 모든 요소가 조건을 불만족 : true

	println("======================================= any ")
	println(foods.any { it.price > 10_000 } ) // 모든 요소가 조건을 하나라도 만족 : true

	println("======================================= count ")
	println(foods.count()) // size 와 동일

	println("======================================= sortedBy ")
	foods.sortedBy { fruit -> fruit.price }.forEach { println(it) }

	println("======================================= sortedByDescending ")
	foods.sortedByDescending { fruit -> fruit.price }.forEach { println(it) }

	println("=======================================  distinctBy")
	foods.distinctBy { it.name }
		.map { it.name }
		.forEach { println(it) }


	foods.first() // 무조건 null, emptyList 면안됨.  없으면 에러
	foods.firstOrNull() // 없으면 null 반환
	foods.last() // 무조건 null, emptyList 면안됨.  없으면 에러
	foods.lastOrNull() // 없으면 null 반환

	println("=======================================  groupBy")
	val groupingFoods = foods.groupBy { it.name } // Map<String, List<Fruit>>
	groupingFoods.keys.forEach { key ->
		println("key: $key")
		groupingFoods[key]?.forEach { println("\t$it") }
	}

	println("=======================================  groupBy 2")
	val groupingFoods2 = foods.groupBy({ it.name }, { it.price }) // Map<String, List<Int>> // 음식이름, List<가격>
	groupingFoods2.keys.forEach { key ->
		println("key: $key")
		groupingFoods2[key]?.forEach { println("\t$it") }
	}

	println("=======================================  associateBy")
	val associatedFoodMap = foods.associateBy { it.id }  // Map<Int, Food> // value 쪽에 단일 객체
	associatedFoodMap[3]?.let { println(it) }

	println("=======================================  associateBy 2")
	val associatedFoodMap2 = foods.associateBy( { it.id }, { it.price } )  // K : 아이디, V : 가격
	associatedFoodMap2[3]?.let { println(it) }

	val foodsInList: List<List<Food>> = listOf(
		listOf(
			Food(1, "라면", 3_000),
			Food(2, "김밥", 2_500),
			Food(3, "떡볶이", 3_500),
		),
		listOf(
			Food(4, "짜장면", 5_000),
			Food(5, "짬뽕", 6_000),
		),
		listOf(
			Food(6, "백반", 9_000)
		)
	)

	println("=======================================  flatten")
	foodsInList.flatten().forEach { println(it) }

	println("=======================================  flatMap")
	foodsInList.flatMap { list -> list.map { it.name } }.forEach { println(it) }


}