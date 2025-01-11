package com.lihan.drinkorderapp.feature.core.domain

import androidx.annotation.DrawableRes
import com.lihan.drinkorderapp.R

data class Drink(
    val name: String,
    val description: String?=null,
    val price: Long,
    val type: DrinkType,
    @DrawableRes val image: Int
)

sealed interface DrinkType {
    data object Coffee: DrinkType
    data object Tea: DrinkType
}

val drinks = listOf<Drink>(
    Drink(name = "Mocha", description = "Espresso with chocolate and steamed milk, often topped with whipped cream.", price = 160, type = DrinkType.Coffee , image = R.drawable.img_mocha),
    Drink(name = "Macchiato", description = "Espresso with a small amount of milk or foam.", price = 125, type = DrinkType.Coffee, image = R.drawable.img_macchiato),
    Drink(name = "Latte", description = "Espresso with a generous amount of steamed milk and a small layer of foam.", price = 150, type = DrinkType.Coffee, image = R.drawable.img_latte),
    Drink(name = "Ristretto", description = "A short and intense shot of espresso made with less water.", price = 110, type = DrinkType.Coffee, image = R.drawable.img_ristretto),
    Drink(name = "Café con Leche", description = "Similar to a latte, made with strong coffee and scalded milk.", price = 150, type = DrinkType.Coffee, image = R.drawable.img_cafe_leche),
    Drink(name = "Café Cubano", description = "Espresso with sugar, creating a sweet and strong coffee.", price = 145, type = DrinkType.Coffee, image = R.drawable.img_mocha),
    Drink(name = "Café Bombón", description = "Espresso with sweetened condensed milk.", price = 175, type = DrinkType.Coffee, image = R.drawable.img_cafe_bombon),
    Drink(name = "Café Cortado", description = "Espresso cut with a small amount of warm milk to reduce the acidity.", price = 140, type = DrinkType.Coffee, image = R.drawable.img_cafe_cortado)
)

