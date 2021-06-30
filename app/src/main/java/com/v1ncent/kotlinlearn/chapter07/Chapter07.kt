package com.v1ncent.kotlinlearn.chapter07

import android.os.Build
import androidx.annotation.RequiresApi
import java.math.BigDecimal
import java.time.LocalDate


/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/29
 * 描    述：
 * 修订历史：
 * ================================================
 */

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    /**
     * 算术运算符
     * 表达式      函数名
     * a*b        times
     * a/b        div
     * a%b        mod
     * a+b        plus
     * a-b        minus
     *
     * +a         unaryPlus
     * -a         unaryMinus
     * !a         not
     * ++a a++    inc
     * --a a--    dec
     */
    println(Point(3, 4) + Point(5, 6))
    println(Point(10, 20) * 1.5)
    println('z' * (5))

    //重载复合赋值运算符
    var point = Point(1, 2)
    point += Point(3, 4)
    println(point)

    val list = ArrayList<Int>()
    list += 3
    //a.plusAssign(b)
    list.plusAssign(300)
    println(list)
    //+= 修改list
    list += listOf(4, 3)
    println(list)

    println(-point)
    var bg = BigDecimal.ONE
    println(bg++)
    println(++bg)

    println(Point(1, 2).equals(Point(3, 4)))

    //下标运算符 []
    val list2 = listOf(1, 2)
    println(list2[1])

    //get
    println(point[1])
    //set
    point[0] = 1
    println(point)

    println(point in (Rectangle(Point(1, 2), Point(3000, 4000))))

    /**
     *  rangeTo的约定 使用 ..
     */
    val now = LocalDate.now()
    val rangeTo = now..now.plusDays(10)
    println(now.plusWeeks(2) in rangeTo)

    /**
     *  lazy 只用于常量 val  lateInit 只用于变量 var
     */
    val s: String by lazy {
        println("lazy init")
        "Hello"
    }
    println(s)
}

/**
 * 定义一个返回结果不同的运算符
 */
operator fun Char.times(a: Int): String {
    return toString().repeat(5)
}

/**
 * 定义一个自增的运算符
 */
operator fun BigDecimal.inc() = this + BigDecimal.TEN