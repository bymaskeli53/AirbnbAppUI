package com.gundogar.airbnbapp

import java.util.Random

object ChildDataFactory {

    private val random = Random()

    private val titles = arrayListOf("Paris", "London", "New York", "Rome")
    private val descriptions = arrayListOf("120 euro for 1 night", "50 euro for 1 night","250 euro for 2 nights","100 USD for 1 night")
    private val images = arrayListOf(
        R.drawable.ic_place_1,
        R.drawable.ic_place_2,
        R.drawable.ic_place_3,
        R.drawable.ic_place_4,
    )

    private fun randomTitle(): String {
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomDescription(): String {
        val index = random.nextInt(descriptions.size)
        return descriptions[index]
    }

    private fun randomImage(): Int {
        return images.random()
    }

    fun getChildren(count: Int): List<Place> {
        val children = mutableListOf<Place>()
        repeat(count) {
            val child = Place(randomImage(), randomTitle(), randomDescription())
            children.add(child)
        }
        return children
    }


}