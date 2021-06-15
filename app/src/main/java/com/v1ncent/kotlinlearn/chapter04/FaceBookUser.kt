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
class FaceBookUser(val account: String) : UserInterface {
    override val nickname = getFaceBookName()//属性初始化

    fun getFaceBookName() = account
}
