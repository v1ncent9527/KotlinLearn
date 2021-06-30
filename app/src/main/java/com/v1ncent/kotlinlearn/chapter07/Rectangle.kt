package com.v1ncent.kotlinlearn.chapter07

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/30
 * 描    述：
 * 修订历史：
 * ================================================
 */
class Rectangle(val upperLeft: Point, val lowerRight: Point)


/**
 * in约定 ： 对应函数为contains
 */
operator fun Rectangle.contains(point: Point): Boolean {
    //.. 闭区间 ： 包括结束值
    //until 开区间 ： 不包括结束值
    return point.x in upperLeft.x..lowerRight.x
            && point.y in upperLeft.y until lowerRight.y
}