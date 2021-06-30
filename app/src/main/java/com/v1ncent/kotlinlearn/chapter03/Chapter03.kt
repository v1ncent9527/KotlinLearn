package com.v1ncent.kotlinlearn.chapter03

import com.v1ncent.kotlinlearn.chapter03.strings.*
import com.v1ncent.kotlinlearn.chapter03.strings.lastChar as last //可以用 as 关键字来修改导入的类或函数名

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/26
 * 描    述：3.函数的定义与调用
 * 修订历史：
 * ================================================
 */

fun main() {
    createCollection()
}

fun createCollection() {
    val set = hashSetOf(1, 2, 3)
    val list = arrayListOf(1, 2, 3)
    //to 不是一个特殊结构，而只是一个普通函数
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")

    //.javaClass 类似于Java的getClass
    println(set)
    //通过打印可知：Kotlin并没有使用自己的集合类，而是采用Java标准的集合类，这样方便和Java进行交互
    println(set.javaClass)
    println(list)
    println(list.javaClass)
    println(map)
    println(map.javaClass)

    //但是kotlin的Api还不止如此
    //last ：最后一个元素
    //max:最大的一个元素
    println(set.first())
    println(list.maxOrNull())

    testJoinToString()
    //顶层函数
    println(joinToStringWithDefaultSignal(list, separator = "//"))
    //顶层属性
    printCount()
    operateCount()
    printCount()
    println("const : $VERSION")

    //扩展函数 (可以用 as 关键字来修改导入的类或函数名)
    println("Kotlin".last())
    println(list.joinToStringWithDefaultExpand())

    //重写
    val view = Button()
    view.click()

    //字符串和正则表达式的处理
    stringDo()
}

fun testJoinToString() {
    val list = arrayListOf("Alice", "Bob", "Cris")
    //在kotlin中调用方法时，可以显示的标注参数的名称
    println(
        joinToString(
            collection = list,
            separator = ";",
            prefix = "(",
            postfix = ")"
        )
    )

    //使用常规语法时，必须按照定义的参数来设置参数，可以省略末尾的已经有默认值的参数
    //使用命名参数，可以任意使用参数，表明即可
    println(joinToStringWithDefault(list, postfix = "}"))
    //注意：参数的默认值是被编码到函数中而不是调用的地方
    println(joinToStringWithDefault(list, postfix = "，，，"))
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * 默认参数值：声明带有默认参数的函数（大量的减轻函数重载的重复性）
 */
fun <T> joinToStringWithDefault(
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "[",
    postfix: String = "]"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * 字符串和正则表达式的处理
 */
fun stringDo() {
    val string = "123.456-6.A"
    println(string.split("\\.|-".toRegex()))
    println(string.split(".", "-"))
    println(string.substringAfterLast("."))
    println(string.substringBefore("."))
    println(string.substringBeforeLast("."))

    //三重引号字符串
    val kotlinLogo = """sa
        |sa
        |sa
    """.trimMargin("|")
    println(kotlinLogo)

}