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

//声明一个接口
interface Clickable {
    fun click()
    fun showOff() = println("Clickable我自带实现方法了！")//在接口中定义一个带方法体的方法，调用者可不用实现
}