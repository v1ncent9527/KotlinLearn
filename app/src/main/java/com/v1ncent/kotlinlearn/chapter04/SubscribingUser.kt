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
class SubscribingUser(val email: String) : UserInterface {

    //重新getter
    override val nickname: String
        get() = email.substringBefore("@")

    override val subName: String
        get() = super.subName + "SubscribingUser"

    //companion
    //伴生对象：工厂方法和静态成员的地盘
    //可以访问private成员或者构造方法
    //可以实现接口
    companion object : JsonFactory<SubscribingUser> {
        override fun fromJson(json: String): SubscribingUser {
            return SubscribingUser("伴生对象")
        }
    }
}