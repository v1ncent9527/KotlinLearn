package com.v1ncent.kotlinlearn.chapter01


/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/24
 * 描    述：1 Kotlin ：定义和目的
 * 修订历史：
 * ================================================
 */

//数据类
data class Person(
    val name: String,
    val age: Int? = null//可空类型
)

//顶层函数
fun main() {
    //命名参数
    val persons = listOf(
        Person("Alice"),
        Person("Bob", 29)
    )

    //lambda表达式（Elvis）
    val oldest = persons.maxByOrNull { it.age ?: 0 }

    //字符串模板
    println("The oldest is ${oldest?.name} 's age is ${oldest?.age} years old")

    println(Person("v1ncent", 29).findAlice())

}

//函数式编程（Kotlin区别于Java之处）
fun Person.findAlice() = this.name == "alice"
