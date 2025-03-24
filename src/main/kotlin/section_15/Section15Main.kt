package org.example.section_15

import org.example.section_14.Food

fun main() {

	val food = Food(1, "라면", 3_000)

	val applyFood = food.apply {
		this.name
	}

	val alsoFood = food.also {
		it.name
	}

	val runFood = food.run {
		this.name
	}

	val letFood = food.let {
		it.name
	}

	with(food) {
		println(name)
		println(this.price)
	}

}
  