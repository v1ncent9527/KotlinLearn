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

class RichButton : Button() {
    override fun click() {
        println("RichButton click")
    }

    override fun animate() {
        println("RichButton animate")
    }
}