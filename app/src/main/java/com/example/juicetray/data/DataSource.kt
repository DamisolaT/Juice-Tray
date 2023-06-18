package com.example.juicetray.data

import android.os.FileObserver.OPEN
import com.example.juicetray.constants.ItemType
import com.example.juicetray.model.JuicyItem

object DataSource {

    val juicyItems = mapOf(
        "pineapple" to
        JuicyItem(
            name = "Pineapple juice",
            description = "Coconut Smoothie,Pina Colada Smoothie",
            price= 3.00,
            type = ItemType.OPEN
        ),

        "lemon" to
        JuicyItem(
            name = "Lemon juice",
            description = "Strawberry lemonade, Lemon sponge cake",
            price= 3.00,
            type = ItemType.OPEN
        ),

         "pomegranate" to
        JuicyItem (
            name = "Pomegranate juice",
            description = "Carrot Beet Juice,Homemade Tomato Juice ",
            price= 4.00,
            type = ItemType.OPEN
        ),

        "berries" to
        JuicyItem (
            name = "Berries juice",
            description = "Raspberries,Strawberries ",
            price= 5.00,
            type = ItemType.OPEN
        ),

        "apple" to
        JuicyItem (
            name = "Apple Juice",
            description = "Green Apple Juice,Carrot Apple juice",
            price= 5.00,
            type = ItemType.SIDE_ORDER

        ),
         "sugar" to
        JuicyItem (
            name = " Sugar Apple Juice",
            description = "Grape Sugar, Lemonade Sugar ",
            price= 5.00,
            type = ItemType.SIDE_ORDER
        ),

        "java" to
        JuicyItem (
            name = " Java Apple Juice",
            description = "love apple,rose apple,wax apple",
            price= 5.00,
            type = ItemType.SIDE_ORDER
        ),
         "custard" to
        JuicyItem (
            name = " Custard Apple Juice",
            description = "Natural Apple,Himrut Green Apple ",
            price= 5.00,
            type = ItemType.SIDE_ORDER
        ),

        "greenleaf" to
        JuicyItem (
            name = "GreenLeaf vegetable",
            description = "Leafy green,spinach,",
            price= 4.00,
            type = ItemType.COMPLEMENT
        ),

         "cruciferous" to
        JuicyItem (
            name = "Cruciferous vegetable",
            description = "Arugula(Rocket), Cabbage",
            price = 4.00,
            type = ItemType.COMPLEMENT
        ),

        "marrow" to
        JuicyItem (
            name = "Marrow vegetable",
            description = "Melon, Cucumber",
            price= 4.00,
            type = ItemType.COMPLEMENT
        )

    )
}