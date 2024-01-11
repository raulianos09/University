package com.example.e_commerce.mockData

import android.media.Image
import java.util.concurrent.locks.Condition
import java.util.function.Predicate
import kotlin.math.roundToInt
import kotlin.random.Random

object DummyItems {
    val ITEMS: MutableList<DummyItem> = ArrayList()
    val ITEM_MAP: MutableMap<Int, DummyItem> = HashMap()
    private var COUNT = 15

    init {
        for (i in 1..COUNT) {
            val random = Random(i)
            val name = "Item $i"
            var price = 0.0
            while (price <= 0) {
                price = (random.nextDouble() * 10000).roundToInt() / 100.0
            }
            var availableQuantity = random.nextInt(0, 100)
            val description = createDescription(name, price, availableQuantity)

            var item = DummyItem(i, name, description, price, availableQuantity)
            ITEMS.add(item)
            ITEM_MAP[item.id] = item
        }
    }

    fun addItem(
        name: String,
        description: String,
        price: Double,
        availableQuantity: Int,
        image: Image?
    ) {
        var item = DummyItem(COUNT + 1, name, description, price, availableQuantity)
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
        COUNT += 1
    }

    fun getSize(): Int {
        return COUNT
    }

    data class DummyItem(
        val id: Int,
        val name: String,
        val description: String,
        val price: Double,
        val availableQuantity: Int,
        val image: Image? = null
    ) {
        override fun toString(): String = name
    }

    private fun createDescription(name: String, price: Double, availableQuantity: Int): String {
        val builder = StringBuilder()
        builder.append("The price of '$name' is $price $ \n")
            .append("There are $availableQuantity items")
        return builder.toString();
    }
}

