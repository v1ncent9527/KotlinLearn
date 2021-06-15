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
interface UserInterface {
    //Kotlin中接口可以声明抽象属性
    //接口可以保护getter,setter属性
    val nickname: String //该属性必须被重写
    val subName: String  //该属性可以被继承
        get() = nickname.substringBefore("@")
}