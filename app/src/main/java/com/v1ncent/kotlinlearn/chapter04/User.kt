package com.v1ncent.kotlinlearn.chapter04

import android.provider.ContactsContract

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/1
 * 描    述：
 * 修订历史：
 * ================================================
 */

//val 意味着相应的属性会用构造方法的参数进行初始化
open class User(
    val nickname: String,

    //可以像函数一样为构造方法参数声明一个默认值
    val isSubscribed: Boolean = true,

    ) {
    var address: String = "unspecified" //可以不定义getter，因为他有访问值了

        set(value) {

            //读取字段的值
            println(
                """
                Address was changed for $nickname :
                "$field" -> "$value".
                
            """.trimIndent()
            )

            //更新字段的值
            field = value
        }
}