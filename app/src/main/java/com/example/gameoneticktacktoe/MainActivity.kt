package com.example.gameoneticktacktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var currentPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val but00: Button = findViewById(R.id.button00)
        val but01: Button = findViewById(R.id.button01)
        val but02: Button = findViewById(R.id.button02)
        val but10: Button = findViewById(R.id.button10)
        val but11: Button = findViewById(R.id.button11)
        val but12: Button = findViewById(R.id.button12)
        val but20: Button = findViewById(R.id.button20)
        val but21: Button = findViewById(R.id.button21)
        val but22: Button = findViewById(R.id.button22)


        val listRow0 = listOf<Button>(but00, but01, but02)
        val listRow1 = listOf<Button>(but10, but11, but12)
        val listRow2 = listOf<Button>(but20, but21, but22)

        val listCol0 = listOf<Button>(but00, but10, but20)
        val listCol1 = listOf<Button>(but01, but11, but12)
        val listCol2 = listOf<Button>(but02, but12, but22)

        val listDiag = listOf<Button>(but00, but11, but22)


        val allButtonsList = listOf<Button>(
            but00,
            but01,
            but02,
            but10,
            but11,
            but12,
            but20,
            but21,
            but22
        )

        allButtonsList.forEach{button ->
            button.setOnClickListener{
                onButtonClick(it, listRow0, listRow1, listRow2, listCol0, listCol1, listCol2, listDiag)
            }

        }

    }

    fun onButtonClick(
        view: View,
        listRow0: List<Button>,
        listRow1: List<Button>,
        listRow2: List<Button>,
        listCol0: List<Button>,
        listCol1: List<Button>,
        listCol2: List<Button>,
        listDiag: List<Button>
    ) {
        val button = view as Button
        if (button.text.isEmpty() && currentPlayer == 1) {
            button.text = "X"
            currentPlayer = 2
            checkForWin(listRow0, listRow1, listRow2, listCol0, listCol1, listCol2, listDiag)
        }
        else if(button.text.isEmpty() && currentPlayer == 2){
            button.text = "0"
            currentPlayer = 1;
        }
    }

    fun checkForWin(
        listRow0: List<Button>,
        listRow1: List<Button>,
        listRow2: List<Button>,
        listCol0: List<Button>,
        listCol1: List<Button>,
        listCol2: List<Button>,
        listDiag: List<Button>
    ){
        val listRow0Concat = listRow0.joinToString("") {button ->
            button.text.toString()
        }

        val listRow1Concat = listRow1.joinToString("") {button ->
            button.text.toString()
        }

        val listRow2Concat = listRow2.joinToString("") {button ->
            button.text.toString()
        }

        val listCol0Concat = listCol0.joinToString("") {button ->
            button.text.toString()
        }

        val listCol1Concat = listCol1.joinToString("") {button ->
            button.text.toString()
        }

        val listCol2Concat = listCol2.joinToString("") {button ->
            button.text.toString()
        }

        val listDiagConcat = listDiag.joinToString("") {button ->
            button.text.toString()
        }

        Log.d("Debug", "ListRow0Concat: $listRow0Concat")
        if(
            listRow0Concat.equals("XXX") ||
            listRow1Concat.equals("XXX") ||
            listRow2Concat.equals("XXX") ||
            listDiagConcat.equals("XXX")
                ){
            Log.d("Debug", "player1 wins")
            Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT)
        }
        else if(
            listCol0Concat.equals("000") ||
            listCol1Concat.equals("000") ||
            listCol2Concat.equals("000") ||
            listDiagConcat.equals("000")
            ){
            Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT)
        }
    }
}




