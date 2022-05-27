package com.tekovelop.data.structure

data class Node<T>(
    val value: T,
    var link: Node<T>? = null,
)

interface LinkedList<T> {
    operator fun plus(item: T)

    fun insertAt(index: Long, item: T)

    fun deleteAt(index: Long)

    fun firstOrNull(predicate: (T) -> Boolean): Node<T>?

    fun firstOrNull(value: T): Node<T>?

    fun getOrNull(index: Long): Node<T>?
}

class LinkedListImpl<T> : LinkedList<T> {
    private var head: Node<T>? = null
    private var count: Long = 0

    override operator fun plus(item: T) {
        if(head == null) {
            head = Node(item)
            count++
            return
        }

        var node = head

        while(node?.link != null) {
            node = node.link
        }

        node?.link = Node(item)
        count++
    }

    override fun insertAt(index: Long, item: T) {
        var cur = 0L

        if(cur == index && head == null) {
            head = Node(item)
            count++
            return
        }

        var node = head

        while(cur++ != index) {
            if (node == null) throw NullPointerException("값을 찾을 수 없습니다.")

            if(cur == index) {
                val temp = node.link
                val newNode = Node(item, temp)
                node.link = newNode
                count++
                return
            }

            node = node.link
        }
    }

    override fun deleteAt(index: Long) {
        var cur = 0L
        var node = head

        if(cur++ == index && head != null) {
            head = head?.link
            count--
            return
        }

        do {
            if (node == null) throw NullPointerException("값을 찾을 수 없습니다.")

            if(cur == index) {
                node.link = node.link?.link
                count--
                return
            }

            node = node.link
        } while(cur++ != index)
    }

    override fun firstOrNull(predicate: (T) -> Boolean): Node<T>? {
        var node = head

        while (node != null) {
            if (predicate(node.value)) return node

            node = node.link
        }

        return null
    }

    override fun firstOrNull(value: T): Node<T>? {
        var node = head

        while (node != null) {
            if (node.value == value) return node

            node = node.link
        }

        return null
    }

    override fun getOrNull(index: Long): Node<T>? {
        var cur = 0L
        var node = head

        while(cur++ != index) {
            if(cur == index || node == null) return node

            node = node.link
        }

        return null
    }
}
