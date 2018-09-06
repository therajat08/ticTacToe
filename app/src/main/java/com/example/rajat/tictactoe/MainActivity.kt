package com.example.rajat.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    protected  fun refClick()
    {

    }


    protected fun buClick(view : View){
            val buSelected = view as Button
            var cellId = 0
            when(buSelected.id){
                R.id.bu1-> cellId = 1
                R.id.bu2-> cellId = 2
                R.id.bu3-> cellId = 3
                R.id.bu4-> cellId = 4
                R.id.bu5-> cellId = 5
                R.id.bu6-> cellId = 6
                R.id.bu7-> cellId = 7
                R.id.bu8-> cellId = 8
                R.id.bu9-> cellId = 9
            }
        //Toast.makeText(this,"Id : "+ cellId, Toast.LENGTH_LONG).show()
        playGame(cellId,buSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(cellId:Int,buSelected:Button)
    {
        buSelected.isEnabled = false
        if(activePlayer==1) {
            buSelected.text = "x"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
        }

        else {
            buSelected.text = "o"
            buSelected.setBackgroundColor(Color.YELLOW)
            player2.add(cellId)
            activePlayer = 1
        }

        checkWinner()
    }
    fun checkWinner()
    {
        var win = -1

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            win = 1
        }

        else if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            win = 2
        }

        //row 2
        else if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            win = 1
        }

        else if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            win = 2
        }

        //row 3
        else if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            win = 1
        }
        else if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            win = 2
        }

        //colum 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            win = 1
        }

        else if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            win = 2
        }

        //column 2
        else if(player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            win = 1
        }

        else if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            win = 2
        }

        //column 3
        else if(player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            win = 1
        }
        else if(player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            win = 2
        }

        // diagonal 1
        else if(player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            win = 1
        }
        else if(player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            win = 2
        }

        // diagonal 2
        else if(player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            win = 1
        }
        else if(player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            win = 2
        }

        if(win != -1)
        {
            if(win == 1)
                Toast.makeText(this,"Player 1 wins the game ", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"Player 2 wins the game ", Toast.LENGTH_LONG).show()
        }
    }
}
