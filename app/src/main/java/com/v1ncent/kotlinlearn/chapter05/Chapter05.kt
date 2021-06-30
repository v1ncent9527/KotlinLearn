package com.v1ncent.kotlinlearn.chapter05

import android.content.Context
import android.widget.TextView


/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/6/15
 * 描    述：lambda编程
 * 修订历史：
 * ================================================
 */

fun main() {

    findTheOldest()

    //lambda表达式语法：始终用{ ... }包围
    // -> 将实参和函数体分开
    val sum = { a: Int, b: Int -> a + b }
    println(sum(4, 2))
    val people = listOf(Person("Alice", 27), Person("Bob", 31))
    println(people.minByOrNull { p: Person -> p.age })
    println(people.maxByOrNull { it.name })

    //把lambda作为实参传递
    println(people.joinToString(separator = " ", transform = { p: Person -> p.name }))
    //把lambda放在括号外传递
    println(people.joinToString("\n") { p: Person -> p.name })

    //显示的写出参数类型
    println(people.maxByOrNull { p: Person -> p.age })
    //推导出参数类型
    println(people.maxByOrNull { p -> p.age })

    //多个表达式或语句构成的lambda
    val sum2 = { a: Int, b: Int ->
        println("我要计算 $a+$b 的值了...")
        sum(a, b)
    }
    println(sum2(10, 11))

    //在作用域中访问变量
    printMessageWithPrefix(listOf("liu", "yue"), "ProHub")
    //在lambda中修改局部变量
    printProblemCounts(listOf("200", "404", "502"))

    //filter:函数遍历集合并选出应用给定的lambda后返回true的那些元素，但是不会改变这些元素
    println(people.filter { it.age > 30 })
    //map:对元素就行变换并收集到一个新的集合
    val list = listOf(1, 2, 3, 4)
    println(list.map { it * it })
    println(people.map { it.name })
    println(people.map(Person::name))
    //可以就行链式调用
    println(people.filter { it.age > 30 }.map { it.name })
    //找出年龄最大的人的名字
    ////该写法会循环person.size()次
    println(people.filter { it.age == people.maxByOrNull { it.age }!!.age })
    ////所以不要再filter调节里面嵌套循环
    val maxAge = people.maxByOrNull(Person::age)!!.age
    println(people.filter { it.age == maxAge })

    val canBeInClub27 = { p: Person -> p.age > 27 }
    //all:检查集合中所有元素是否符合某个条件
    println(people.all(canBeInClub27))
    //any:检查集合中至少有一个元素符合某个条件
    println(people.any(canBeInClub27))
    //count:检查集合中满足条件的元素数量
    println(people.count(canBeInClub27))
    ////区别于list.size  filter会创建一个中间集合，而count只在乎数量而不是元素本身
    println(people.filter(canBeInClub27).size)
    //find:找到满足条件的第一个元素 等同于firstOrNull
    println(people.find(canBeInClub27))
    println(people.firstOrNull(canBeInClub27))
    //groupBy:按照条件进行分组 返回一个map<int,List<Person>>
    println(people.groupBy { it.age })
    val list2 = listOf("a", "ab", "b")
    println(list2.groupBy(String::first))
    //flatMap:处理嵌套集合中的元素
    println(list2.flatMap { it.toList() })
    println(list2.flatMap { it.toList() }.toSet())

    //惰性集合操作：序列 由于filter、map等都会返回一个中间列表，数据量大效率就会很低
    val sequenceList = people.asSequence()  //集合转化为序列：和集合使用医用的API
        .filter { it.name.startsWith("A") } //先使用filter能够有效的减少变换的次数
        .map(Person::name)
        .toList()//将结果序列转换回列表
    println(sequenceList)
    //只有调用末端操作（toList等）才会调用中间操作
    val sequenceList2 =
        listOf(1, 2, 3, 4)
            .asSequence()
            .map { println("map($it)");it * it }
            .filter { println("filter($it)");it % 2 == 0 }
            .toList()
    println(sequenceList2)
    //generateSequence:创建序列
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    //with
    println(alphabet())
    //apply
    println(alphabetWithApply())
    println(alphabetWithBuildString())
}

fun findTheOldest() {
    val person = arrayListOf(
        Person("alice", 24),
        Person("bob", 21),
        Person("club", 29)
    )

    var maxAge = 0
    var maxPerson: Person? = null

    for (person in person) {
        if (person.age > maxAge) {
            maxAge = person.age
            maxPerson = person
        }
    }
    println(maxPerson)

    //maxByOrNull可以在任何集合上使用，且只需要一个实参：一个函数，指定比较那个值来找出最大元素

    //使用it来引用实参
    println(person.maxByOrNull { it.age })
    //成员引用：主要此处为（）而不是{}
    println(person.maxByOrNull(Person::age))
}

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        //在lambda使用函数参数（Java中是不允许的）
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientError = 0
    var serverError = 0
    //在lambda中修改局部变量
    responses.forEach {
        if (it.startsWith("4")) {
            clientError++
        } else if (it.startsWith("5")) {
            serverError++
        }
    }
    println("clientErrorCounts$clientError serverErrorCounts$serverError ")
}

/**
 * with:带接受者的lambda
 */
fun alphabet(): String =
    with(StringBuilder()) {//指定接收着的值
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nI Know the alphabet") //省略this
        this.toString()//从lambda返回值
    }

/**
 * apply:几乎和with一模一样，唯一的区别是apply始终会返回接受者对象
 */
fun alphabetWithApply(): String =
    StringBuilder().apply {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nI Know the alphabet")
    }.toString()

/**
 * 使用apply创建一个TextView
 */
fun createViewWithCustomAttributes(context: Context) =
    TextView(context).apply {
        text = "createViewWithCustomAttributes"
        textSize = 20f
        setPadding(0, 0, 0, 0)
    }

fun alphabetWithBuildString() = buildString {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
}