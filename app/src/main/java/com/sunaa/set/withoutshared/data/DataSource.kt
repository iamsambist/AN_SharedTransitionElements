package com.sunaa.set.withoutshared.data

import com.sunaa.set.R

class DataSource {
    private val vegetables = ListItems(
        R.string.item1Name, R.drawable.vegetables, R.string.item1Des
    )
    private val soup = ListItems(R.string.item2Name, R.drawable.vsoup, R.string.item2Des)

    private val noodles = ListItems(R.string.item3Name, R.drawable.vnoodles, R.string.item3Des)

    fun getVegetable() : ListItems{
        return vegetables
    }
    fun getSoup() : ListItems{
        return soup
    }
    fun getNoodles() : ListItems{
        return noodles
    }
    fun getListOfItems() : List<ListItems>{
        return listOf(vegetables,soup,noodles)
    }
}