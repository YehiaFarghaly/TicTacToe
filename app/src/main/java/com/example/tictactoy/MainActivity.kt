package com.example.tictactoy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun buSelect(view:View) {
        val buChoice = view as Button
        var cellID=0
        when(buChoice.id) {
            R.id.bu1->cellID=1
            R.id.bu2->cellID=2
            R.id.bu3->cellID=3
            R.id.bu4->cellID=4
            R.id.bu5->cellID=5
            R.id.bu6->cellID=6
            R.id.bu7->cellID=7
            R.id.bu8->cellID=8
            R.id.bu9->cellID=9
        }

        playGame(cellID,buChoice)


    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer=1
    fun playGame(cellID:Int,butChoice:Button) {
        if(activePlayer==1) {
            butChoice.text="X"
            butChoice.setBackgroundResource(R.color.teal_200)
            player1.add(cellID)
            activePlayer=2
            var x = checkWinner()
            endGame(x)
            if(x==1) return
            if(intent.extras!!.get("mode")==2)
            autoPlay()
        }
        else {
            butChoice.text="O"
            butChoice.setBackgroundResource(R.color.purple_200)
            player2.add(cellID)
            activePlayer=1
            endGame(checkWinner())
        }
        butChoice.isEnabled=false


    }
    fun autoPlay() {
        val emptyCells = ArrayList<Int>()
        for(cellID in 1..9) {
            if(!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }
        val r = Random()
        val randIdx = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIdx]
        var buSelect:Button = bu1
        when(cellID) {
            1->buSelect=bu1
            2->buSelect=bu2
            3->buSelect=bu3
            4->buSelect=bu4
            5->buSelect=bu5
            6->buSelect=bu6
            7->buSelect=bu7
            8->buSelect=bu8
            9->buSelect=bu9
        }
        playGame(cellID,buSelect)
    }
    fun checkWinner():Int {
        var winner = -1
        if((player1.contains(1) &&player1.contains(2) && player1.contains(3)) ||
            (player1.contains(4) &&player1.contains(5) && player1.contains(6)) ||
            (player1.contains(7) &&player1.contains(8) && player1.contains(9)) ||
            (player1.contains(1) &&player1.contains(4) && player1.contains(7)) ||
            (player1.contains(2) &&player1.contains(5) && player1.contains(8)) ||
            (player1.contains(3) &&player1.contains(6) && player1.contains(9)) ||
            (player1.contains(1) &&player1.contains(5) && player1.contains(9)) ||
            player1.contains(7) &&player1.contains(5) && player1.contains(3)
                ) {
            winner = 1
        }
        else if((player2.contains(1) &&player2.contains(2) && player2.contains(3)) ||
            (player2.contains(4) &&player2.contains(5) && player2.contains(6)) ||
            (player2.contains(7) &&player2.contains(8) && player2.contains(9)) ||
            (player2.contains(1) &&player2.contains(4) && player2.contains(7)) ||
            (player2.contains(2) &&player2.contains(5) && player2.contains(8)) ||
            (player2.contains(3) &&player2.contains(6) && player2.contains(9)) ||
            (player2.contains(1) &&player2.contains(5) && player2.contains(9)) ||
            player2.contains(7) &&player2.contains(5) && player2.contains(3)){
            winner = 2
        }

        return winner;
    }
    fun endGame(player:Int) {
        if(player==1) {
       var intent=Intent(this,endActivity::class.java)
        intent.putExtra("winner",player)
            startActivity(intent)
        }
        else if(player==2) {
            var intent = Intent(this,endActivity::class.java)
            intent.putExtra("winner",player)
            startActivity(intent)
        }
    }

}