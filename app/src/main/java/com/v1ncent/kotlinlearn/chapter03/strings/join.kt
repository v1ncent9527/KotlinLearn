@file:JvmName("Join")//注解指定类名，位于包名前面

package com.v1ncent.kotlinlearn.chapter03.strings

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/26
 * 描    述：消除静态工具类：顶层函数和属性
 * 修订历史：
 * ================================================
 */

/**
 * 可以把函数和属性放在代码的顶层，他不属于任何的类
 */
fun <T> joinToStringWithDefaultSignal(
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
 * 顶层属性
 */
var opCount: Int = 0

fun operateCount() {
    opCount++
}

fun printCount() {
    println("opCount=$opCount")
}

/**
 * const 相当于Java的public static final
 */
const val VERSION = "1.0.0"

/**
 * 扩展函数 this亦可省略
 * 扩展函数的静态属性决定了他不能被子类重写
 */
fun String.lastChar() = this.get(this.length - 1)

fun <T> Collection<T>.joinToStringWithDefaultExpand(
    separator: String = ",",
    prefix: String = "[",
    postfix: String = "]"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

open class View {
    open fun click() = println("view click")
}

class Button : View() {
    override fun click() = println("button click")
}

