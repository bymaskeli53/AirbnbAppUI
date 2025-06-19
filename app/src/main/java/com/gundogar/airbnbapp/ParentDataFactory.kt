package com.gundogar.airbnbapp

import java.util.Random

object ParentDataFactory{
    private val random = Random()

    private val titles =  arrayListOf( "The best hotels in your area", "The best suits in your area", "The best rooms in your area")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomChildren() : List<Place>{
        return ChildDataFactory.getChildren(6)
    }

    fun getParents(count : Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        repeat(count){
            val parent = ParentModel(randomTitle(), randomChildren())
            parents.add(parent)
        }
        return parents
    }
}