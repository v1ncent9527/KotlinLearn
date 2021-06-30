package com.v1ncent.kotlinlearn.chapter06

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
class Employee(val name: String, val manage: Employee?)

// ?. 不仅可以用来调用方法，亦可调用属性
fun manageName(employee: Employee): String? = employee.manage?.name