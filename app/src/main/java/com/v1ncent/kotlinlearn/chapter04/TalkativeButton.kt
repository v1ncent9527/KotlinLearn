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
 * interface:模块中可见
 */
interface open
class TalkativeButton : Focusable {
    private fun yell() = println("yell")

    //protected :
    //java：同一个包中可以相互访问
    //kotlin:只有在类中或者子类才能访问，扩展函数也不能访问呗private和protected修饰的成员
    protected fun whisper() = println("whisper")
}

//扩展函数中也不能访问相关方法
fun TalkativeButton.aaa() {
//    yell()
//    whisper()
}