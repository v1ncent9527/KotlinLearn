package com.v1ncent.kotlinlearn.chapter06

import java.util.*

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/28
 * 描    述：Kotlin的系统类型
 * 修订历史：
 * ================================================
 */

fun main() {

    //什么叫做类型？？
    //类型就是数据的分类，决定了该类型可能的值，已经在该类型上可以完成的操作。
    println(strLen("strLen"))
    println(strLen(null))

    println(printAllCaps("abc"))

    val ceo = Employee("Alice", null)
    val dev = Employee("Bob", ceo)
    println(manageName(ceo))
    println(manageName(dev))

    foo("666")
    foo(null)

    printShippingLabel(
        Person(
            "Alice",
            Company("linkByte", Address("津静路26号", 110, "tj", "cn"))
        )
    )
//    printShippingLabel(Person("Alice", null))

    testAs(null)

    var email: String? = "10002@11.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
}

/**
 * Type？ = Type or null
 *
 * 这说明所有常见类型默认都是非空的，除非显式的把他标记为可空
 */
fun strLen(s: String?) = s?.length


/**
 * 安全调用运算符 ?.
 */
fun printAllCaps(s: String?) {
    val allCaps = s?.toUpperCase(Locale.ROOT)
    println(allCaps)
}

/**
 * Elvis运算符 ?:  null合并运算符
 */
fun foo(s: String?) {
    val t: String = s ?: "I am null !"
    println(t)
}

/**

 * 同时使用throw 和 Elvis
 */
fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")

    with(address) {
        println(streetAddress)
        println("$zipCode,$city,$country")
    }
}

/**
 * as? :安全转换
 */
fun testAs(x: Any?) {
    val person = x as? Person? ?: false
    println(person)
}

fun sendEmailTo(email: String) {
    println("Send email to $email")
}