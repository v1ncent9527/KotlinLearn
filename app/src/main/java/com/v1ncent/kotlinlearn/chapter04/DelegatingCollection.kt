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
 * 委托是一种设计模式，基本理念是：操作对象自己不会去处理某段逻辑，而是会把工作委托给另外一个辅助对象去处理
 * 类委托：将一个类的一些具体实现委托给另一个类去完成
 */
class DelegatingCollection<T>(val innerList: Collection<T> = ArrayList<T>()) :
    Collection<T> by innerList