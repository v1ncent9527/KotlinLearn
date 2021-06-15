package com.v1ncent.kotlinlearn.chapter04

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/31
 * 描    述：
 * 修订历史：
 * ================================================
 */

/**
 * Kotlin中的类和其中的方法都是final的，不能被继承或者重写
 */

//实现Clickable接口 Kotlin中使用 ： 代替extend,implements
//这个类为open，可以被其他类继承
open class Button : Clickable, Focusable {

    //这个函数重写了open函数，并且它本身也是open函数 若加final则不能重写
    //override 是强制要求添加的，防止重名
    override fun click() {
        println("I was clicked")
    }

    /**
     * 若继承的接口含有用一个回调方法名
     * 则需要显式的指定是哪个父类的回调(将基类的名字放在尖括号中，类似于Java的 基类.super.xx)
     */
    override fun showOff() {
        super<Focusable>.showOff()
    }

    fun disable() {}//这个函数是final的,不能在子类中重写

    open fun animate() {}//这个函数是open的,能在子类中重写
}