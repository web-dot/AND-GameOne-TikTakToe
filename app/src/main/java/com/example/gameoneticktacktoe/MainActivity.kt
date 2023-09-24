package com.example.gameoneticktacktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

private lateinit var buttons: Array<Array<Button>>
private var currentPlayer = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttons = Array(3){row ->
            Array(3){col ->
                findViewById<Button>(resources.getIdentifier("button$row$col", "id", packageName))
            }
        }

    }

    fun onButtonClick(view: View){
        val button = view as Button
        val row = button.tag.toString().toInt() / 10
        val col = button.tag.toString().toInt() % 10

        // check if the clicked cell is empty

    }
}




