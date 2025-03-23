package org.example.section_9

class Character private constructor(
    val name: String,
    val level: Int,
) {

    // static 키워드 없음..
    // 이름을 붙일수도있으 ex : companion object Factory
    // 다른 인터페이스를 구현(implements) 하는것도 가능
    companion object {
        private const val MIN_LEVEL = 1
        fun newCharacter(name: String): Character {
            return Character(name, MIN_LEVEL)
        }
    }
}