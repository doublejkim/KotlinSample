package org.example.section_1_4

import section_1_4.Student
import java.io.BufferedReader

fun main() {

    val student1 = Student("Jack", 25)
    val student2 = Student("Tom", 30)

    if (student1 > student2) {
        println("1번학생이 2번학생보다 나이가 많다")
    } else {
        println("2번학생이 1번학생보다 나이가 같거나 많다")
    }

    val s1 = Student("AAA", 10)
    val s2 = s1
    val s3 = Student("AAA", 20)

    println(s1 === s2)
    println(s1 == s2)
    println(s1 == s3)


    for (i in 1..<10) {
        println(i)  // 1 3 5 7 9
    }


}