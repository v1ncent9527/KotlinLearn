package com.v1ncent.kotlinlearn.chapter04

import java.io.File

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/5/31
 * 描    述：类，对象和接口
 * 修订历史：
 * ================================================
 */

fun main() {

    println(Button().click())
    println(Button().showOff())
    println(Button().setFocus(true))
    println(RichButton().animate())

    val alice = User("Alice")//isSubscribed参数使用默认值true
    val bob = User("Bob", false)
    val carol = User("Carol", isSubscribed = true)//可以显示的为构造方法标明参数名称
    carol.address = "天塔第一层马迭尔"
    carol.address = "天塔第一层马迭尔2"

    println(alice)
    println(bob)
    println(carol)

    val twitterUser = TwitterUser("v1ncent")
    println(twitterUser.isSubscribed)

    //主构造方法初始化
    println(PrivateUser("v1ncent").nickname)
    //自定义getter
    println(SubscribingUser("1041066648@qq.com").subName)
    //属性初始化
    println(FaceBookUser("facebook").nickname)

    //重写toString
    println(Client("v1ncent", "995"))
    //Kotlin中 == 比较的是对象而不是引用，这里会被变编译调用 equals
    val client1 = Client("Alice", "9925")
    val client2 = Client("Alice", "9925")
    //重写equals
    println(client1 == client2)
    //重写hashCode
    val clientSet = setOf(Client("Alice", "9925"))
    println(clientSet.contains(Client("Alice", "9925")))
    //copy:数据类强烈建议属性设置成只读（val）,这样一旦创建则一直保持原始的状态
    println(client2.copy(postalCode = "65535"))
    //类委托
    println(DelegatingCollection(arrayListOf("委托", "测试")).size)

    //单例
    CaseInsensitiveFileComparator.compare(File("/user"), File("/User"))
    //伴生对象
    println(SubscribingUser.fromJson("777").nickname)
}