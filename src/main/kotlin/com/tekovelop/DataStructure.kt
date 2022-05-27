package com.tekovelop

import com.tekovelop.data.structure.LinkedListImpl

fun main(args: Array<String>) {
    val list = LinkedListImpl<Long>()

    list.plus(1)
    list.plus(2)
    list.plus(4)
    list.plus(5)

    println(list)

    list.insertAt(2, 3)
    list.insertAt(2, 3)

    println(list)

    list.deleteAt(2)

    println(list)

    val found = list.firstOrNull {
        it == 4L
    }

    println(found)
}
