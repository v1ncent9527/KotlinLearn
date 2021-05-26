package com.v1ncent.kotlinlearn.chapter02

import android.util.Size
import java.io.BufferedReader
import java.io.StringReader
import java.util.*

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/24
 * 描    述：2 Kotlin 基础
 * 修订历史：
 * ================================================
 */

fun main() {
    //1,用关键字 fun 来声明一个函数
    //2,参数的类型写在名称后面
    //3,函数可以定义在文件的最外层，不需要把他放在类中
    //4,可以省略末尾的 ；
    println("Hello kotlin")

    println(max(10, 11))
    println(maxShort(100, 110))
    variable()
    variableKeyword()

    val rectangle = Rectangle(4, 4)
    println("rectangle is isSquare ? ${rectangle.isSquare}")
    println("createRandomRectangle is isSquare ? ${createRandomRectangle().isSquare}")

    println(Color.BLUE.rgb())
    println(getMnemonic(Color.YELLOW))
    println(getWarmth(Color.GREEN))
    println(mix(Color.RED, Color.YELLOW))
    println(mixOptimized(Color.RED, Color.YELLOW))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval2(Sum(Sum(Num(1), Num(2)), Num(5))))
    println(eval3(Sum(Sum(Num(1), Num(2)), Num(6))))
    println(evalLog(Sum(Sum(Num(1), Num(2)), Num(7))))

    //区间：一个起始值，一个结束值，中间用 .. 连接，注意:区间是闭合的
    val one2han = 1..100
    for (i in one2han) {
        println("$i is ${fizzBuzz(i)}")
    }

    //downTo：到xx为止 step:步长
    for (i in 100 downTo 50 step 2) {
        println("$i is ${fizzBuzz(i)}")
    }

    //utils：非闭合
    for (i in 0 until 100) {
        println("$i is ${fizzBuzz(i)}")
    }

    iterateMap()

    println(isLetter('c'))
    println(isNotDigit(9))
    inWhen('1')
    inWhen('c')
    println("Kotlin" in "Java".."PHP")
    println("Kotlin" in "Java".."C")
    println("Kotlin" in setOf("A", "VB"))

    testThrow(1)
//    testThrow(100)
    println(readNumber(BufferedReader(StringReader("10d24"))))
    println(readNumber2(BufferedReader(StringReader("10d24"))))
}

/**
 * 取2个数的最大值
 */
fun max(a: Int, b: Int): Int {
    //这里的if是一个表达式
    //表达式和语句的区别在于：
    //表达式：有值，并且可以作为另一个表达式的一部分
    //语句：没有值，并且包围着代码块的顶层元素

    //Java中所有的控制结构都是语句
    //Kotlin中处了循环（for、do、do/while）外大多数控制结构都是表达式
    return if (a > b) a else b
}

//可以简写如下
//自动类型推导：
fun maxShort(a: Int, b: Int) = if (a > b) a else b

/**
 * 变量
 * 关键字+变量名称+类型（可不加）
 */
fun variable() {
    //隐式
    val a = 12
    //显式
    val a1: Int = 12

    //如果变量没有初始化值，则需要显式的指定变量的类型
    val a2: Int
    a2 = 12

    println("variable is a=$a  a1=$a1 a2=$a2")
}

/**
 * 可变变量和不可变量
 *
 * val(value):不可变引用，值不可在初始化后再次赋值（相对应Java final）
 * var(variable):可变引用，值可多次赋值
 *
 * 默认情况下，尽可能使用val声明变量，可以是代码更接近函数式编程风格
 */
fun variableKeyword() {
    //val 可以根据不同的条件来初始化
    val valValue: Int
    if (max(1, 2) > 3)
        valValue = 5
    else
        valValue = 6

    println("valValue is $valValue")

    //注意：尽管val引用本身是不可变的，但是它指向的对象可能是可变的，如下
    val list = arrayListOf("Alice", "Bob")
    list.add("v1ncent")
    println("list is $list")

    var varValue = 13
//    valValue = "change to string"  类型不匹配（须手动装换或者强转）】
    println("varValue is $varValue")
}

fun fizzBuzz(a: Int) =
    when {
        a % 15 == 0 ->
            "FizzBuzz"
        a % 3 == 0 ->
            "Fizz"
        a % 5 == 0 ->
            "Buzz"
        else ->
            a
    }

/**
 * 迭代Map
 */
fun iterateMap() {
    val map = TreeMap<Char, String>()
    //..语法不仅可以用来创建数字集合，亦可创建char集合
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        map[c] = binary
    }

    for (mutableEntry in map) {
        println("${mutableEntry.key} - > ${mutableEntry.value}")
    }
}

//in 检查一个值是否属于某个区间 相反的对呀 !in
fun isLetter(c: Char) = c in 'A'..'F'

fun isNotDigit(i: Int) = i !in 0..7

fun inWhen(c: Char) =
    when (c) {
        in 0..9 -> println("digit")
        in 'A'..'F', in 'a'..'f' -> println("digit")
        else -> println("unknown")
    }

/**
 * Throw: 结构是一个表达式
 */
fun testThrow(i: Int) =
    if (i in 0..10) println(i)
    else throw Exception("必须输入0~10之间的数字")

/**
 * try catch :不必显式的指定这个函数可能抛出的异常，即不区分受检异常和未受检异常
 */
fun readNumber(read: BufferedReader): Int? {
    try {
        val line = read.readLine()
        return Integer.parseInt(line)
    } catch (e: Exception) {
        return null
    } finally {
        read.close()
    }
}

/**
 * try可作为表达式使用
 */
fun readNumber2(read: BufferedReader) {
    val line = try {
        Integer.parseInt(read.readLine())
    } catch (e: NumberFormatException) {
        e.message
    }

    println(line)
}