package com.v1ncent.kotlinlearn.chapter02

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/25
 * 描    述：
 * 修订历史：
 * ================================================
 */

//这里的enum是一个软关键字，只有出现在class前面才有特殊的意义，在其他地方可以当做普通名称使用
//枚举并不是值的列表：可以给枚举类声明属性和方法
enum class Color(val r: Int, val g: Int, val b: Int) {//声明枚举常量的属性

    //当声明一个枚举常量的时候，必须提供该常量的属性值
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    INDIGO(75, 0, 130),
    BLUE(0, 0, 255),
    VIOLET(238, 130, 238);//Kotlin中唯一使用分号的地方：主要为了常量和方法区分开;

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
    //when 是一个具有返回值的表达式
    when (color) {
        Color.RED -> "赤"
        Color.ORANGE -> "橙"
        Color.YELLOW -> "黄"
        Color.GREEN -> "绿"
        Color.INDIGO -> "青"
        Color.BLUE -> "蓝"
        Color.VIOLET -> "紫"
    }

fun getWarmth(color: Color) =
    when (color) {
        //可以把多个值合并到一个分支，用 ， 隔开即可
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
    }

fun mix(c1: Color, c2: Color) =
    //作为分支条件，Kotlin区别于Java的地方是 Kotlin的when表达式的实参可以为任意对象
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO

        //若未匹配到任何分支，在会再次执行（对应Java default）
        else -> throw Exception("Dirty color")
    }

/**
 * 使用不带参数的when
 */
fun mixOptimized(c1: Color, c2: Color) =
    //没有实参传给when
    when {
        //分支条件即为 任意的布尔型
        (c1 == Color.RED && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }