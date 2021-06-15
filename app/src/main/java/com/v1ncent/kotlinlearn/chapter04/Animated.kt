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
 * abstract :抽象类，不能被实例化
 */
abstract class Animated {
    //抽象方法，必须被子类重写
    abstract fun animate()

    //非抽象方法：并不是默认open，但是可以手动指定open
    open fun stopAnimate() {}

    fun animateTwice() {}
}