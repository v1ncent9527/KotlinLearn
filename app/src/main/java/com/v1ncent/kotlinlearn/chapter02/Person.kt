package com.v1ncent.kotlinlearn.chapter02

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/24
 * 描    述：
 * 修订历史：
 * ================================================
 */

/**
 * 这种类被叫做 值对象
 * 在Kotlin中 public是默认的可见性，所有可以省略
 */

//类
class Person(val name: String, val isMarried: Boolean) {
    //只读属性：生成一个字段和getter
    val name1: String
        get() {
            return name
        }


    //可写属性：一个字段，一个getter,一个setter
    var isMarried2: Boolean
        get() {
            return false
        }
        set(value) {
        }
}