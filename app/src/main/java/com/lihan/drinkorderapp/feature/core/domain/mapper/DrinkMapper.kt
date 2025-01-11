package com.lihan.drinkorderapp.feature.core.domain.mapper

import com.lihan.drinkorderapp.feature.core.domain.Drink
import com.lihan.drinkorderapp.feature.core.domain.DrinkType
import com.lihan.drinkorderapp.feature.home.presentation.model.DrinkUI


fun Drink.toDrinkUI(): DrinkUI {
    return DrinkUI(
        name = this.name,
        description = this.description?:"",
        price = this.price.toString(),
        img = this.image,
        type = this.type.toInt()
    )
}

private fun DrinkType.toInt(): Int {
    return when(this){
        DrinkType.Coffee -> 0
        DrinkType.Tea -> 1
    }
}