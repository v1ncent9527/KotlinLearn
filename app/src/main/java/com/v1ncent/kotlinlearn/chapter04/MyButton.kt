package com.v1ncent.kotlinlearn.chapter04

import android.content.Context

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/1
 * 描    述：
 * 修订历史：
 * ================================================
 */
class MyButton : View {
    //调用父类的构造方法，亦可委托给这个类的另一个构造方法
    constructor(c: Context) : this(c, "委托给这个类的另一个构造方法")
    constructor(c: Context, string: String) : super(c, string)
}