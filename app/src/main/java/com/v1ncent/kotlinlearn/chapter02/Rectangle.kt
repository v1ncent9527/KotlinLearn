package com.v1ncent.kotlinlearn.chapter02 //包引用

import java.util.Random//导入标准的Java库

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
class Rectangle(val width: Int, val height: Int) {
    //自定义访问器
    val isSquare: Boolean
        //        get() {
//            return width == height
//        }
        get() = width == height
}

/**
 * kotlin不区分导入的是 类 还是 函数,并且它允许使用import关键字导入任何类的声明。可以直接导入顶层函数的名称
 */
fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}