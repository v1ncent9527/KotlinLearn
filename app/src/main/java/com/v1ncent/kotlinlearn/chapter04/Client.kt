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
 * data:数据类，自动生成通用方法的实现（注意：只有主构造方法声明的属性才纳入考虑）
 */
data class Client(val name: String, val postalCode: String) {

//    //重写toString
//    override fun toString(): String {
//        return "Client(name=$name,postalCode=$postalCode)"
//    }
//
//    //重写equals
//    override fun equals(other: Any?): Boolean {
//        if (other == null || other !is Client)
//            return false
//        return name == other.name
//                && postalCode == other.postalCode
//    }
//
//    //重写hashCode
//    override fun hashCode(): Int {
//        return name.hashCode() + postalCode.hashCode()
//    }
}