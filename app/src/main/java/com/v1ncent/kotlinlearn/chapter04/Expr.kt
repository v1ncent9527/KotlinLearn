package com.v1ncent.kotlinlearn.chapter04

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/1
 * 描    述：
 * 修订历史：
 * ================================================
 */

/**
 * sealed：密封类，默认为open类型
 */
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(expr: Expr) =
    /**
     * 在when中处理所有sealed类的子类时，不需要默认的分支（else）
     */
    when (expr) {
        is Expr.Num -> ""
        is Expr.Sum -> ""
//        else -> ""
    }