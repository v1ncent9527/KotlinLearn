package com.v1ncent.kotlinlearn.chapter07

import java.lang.Exception

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/29
 * 描    述：
 * 修订历史：
 * ================================================
 */
data class Point(var x: Int, var y: Int) {

    /**
     * 重载算数运算符：operator 关键字就行修饰
     */
    operator fun plus(point: Point): Point {
        return Point(x + point.x, y + point.y)
    }

    /**
     * === 恒等运算符，相当于Java的 == 比较的是对象的引用
     */
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point) return false
        return other.x == x && other.y == y
    }


}

/**
 * 处了声明成员函数之外，亦可定义成一个扩展函数
 */
operator fun Point.plus(point: Point): Point {
    return Point(x + point.x, y + point.y)
}

/**
 * 定义一个运算数类型不同的运算符
 */
operator fun Point.times(double: Double): Point {
    return Point(x * double.toInt(), y * double.toInt())
}

/**
 *  重载一元运算符，没有任何参数
 */
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

/**
 * get约定
 */
operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw Exception("not findx $index")
    }
}

operator fun Point.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw Exception("not findx $index")
    }
}