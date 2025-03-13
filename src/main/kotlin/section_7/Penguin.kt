package org.example.section_7

class Penguin(
    name: String,
) : Animal(name, 2), Flyable, Swimmable{

    private val wingCount: Int = 2

    override fun speak() { println("짹") }

    // override 키워드로 부모클래스의 legCount 프로퍼티를 오버라이딩. customer getter 로 기능 구현
    override var legCount: Int = 0
        get() = super.legCount + this.wingCount

    override fun doIt() {
        super<Flyable>.doIt() // 중복되는 인터페이스를 특정할때는 super<타입>.메소드 형태로 사용
        super<Swimmable>.doIt()
    }
}