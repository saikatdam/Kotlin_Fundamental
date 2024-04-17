package com.example.shoppingingredients

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BasicIngredients : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_basic_ingredients)

    val dishName = intent.getStringExtra(EXTRA_DISH_NAME_KEY)
    findViewById<TextView>(R.id.ingredients_list).text=when(dishName){
        "HumBurger"->"Minced meat\nBun\nTomato"
        "Pasta"->"Spaghetti\nTomato\nParmesan"
        else -> "Unknown Dish"
    }



}
    companion object {
        const val EXTRA_DISH_NAME_KEY = "DishName"

        fun start(context: MainActivity, dishName: String) {
            val intent = Intent(context, BasicIngredients::class.java).apply {
                putExtra(EXTRA_DISH_NAME_KEY, dishName)
            }
            context.startActivity(intent)
        }
    }
}
