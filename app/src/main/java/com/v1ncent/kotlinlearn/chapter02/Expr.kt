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
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr): Int {
    if (expr is Num) {
        //显示的转换类型是多余的
        val n = expr as Num
        return n.value
    }
    //Kotlin中使用 is 来判断一个变量是否属于某个类型 （类似于Java的instanceOf）
    if (expr is Sum) {
        //变量expr智能的转换了类型，转换过的值会用不同的颜色背景着重显示
        return eval(expr.left) + eval(expr.right)
    }
    throw Exception("unknown exception")
}

fun eval2(expr: Expr) =
    //使用if表达式作为函数体
    if (expr is Num) {
        val n = expr as Num
        n.value
    } else if (expr is Sum) {
        eval(expr.left) + eval(expr.right)
    } else
        throw Exception("unknown exception")

fun eval3(expr: Expr): Int =
    when (expr) {
        //智能转换-》检测实参的类型
        is Num ->
            expr.value
        is Sum ->
            eval3(expr.left) + eval3(expr.right)
        else ->
            throw Exception("unknown exception")
    }

fun evalLog(expr: Expr): Int =
    when (expr) {
        //当分支逻辑过于复杂，则可使用代码块作为分支体
        is Num -> {
            println("expr value is ${expr.value}")
            expr.value
        }
        is Sum -> {
            evalLog(expr.left) + evalLog(expr.right)
        }
        else ->
            throw Exception("unknown exception")
    }
