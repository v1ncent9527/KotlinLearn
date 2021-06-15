package com.v1ncent.kotlinlearn.chapter04

import java.io.File
import java.util.Comparator

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
 * object :单例模式，不需要构造方法可直接调用属性和方法
 */
object CaseInsensitiveFileComparator : Comparator<File> {

    override fun compare(o1: File, o2: File): Int {
        return if (o1.path.equals(o2.path)) 1 else 2
    }
}