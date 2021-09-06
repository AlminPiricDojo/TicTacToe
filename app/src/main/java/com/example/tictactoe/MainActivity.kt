package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private lateinit var btTopL: Button
    private lateinit var btTop: Button
    private lateinit var btTopR: Button
    private lateinit var btMidL: Button
    private lateinit var btMid: Button
    private lateinit var btMidR: Button
    private lateinit var btBotL: Button
    private lateinit var btBot: Button
    private lateinit var btBotR: Button

    private lateinit var tvWinner: TextView

    private lateinit var cvPlayer1: CardView
    private lateinit var cvPlayer2: CardView

    private lateinit var buttons: List<Button>
    private var playerOneTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWinner = findViewById(R.id.tvWinner)

        cvPlayer1 = findViewById(R.id.cvPlayer1)
        cvPlayer2 = findViewById(R.id.cvPlayer2)

        cvPlayer1.setBackgroundColor(Color.MAGENTA)

        btTopL = findViewById(R.id.btTopL)
        btTop = findViewById(R.id.btTop)
        btTopR = findViewById(R.id.btTopR)
        btMidL = findViewById(R.id.btMidL)
        btMid = findViewById(R.id.btMid)
        btMidR = findViewById(R.id.btMidR)
        btBotL = findViewById(R.id.btBotL)
        btBot = findViewById(R.id.btBot)
        btBotR = findViewById(R.id.btBotR)

        buttons = listOf(btTopL, btTop, btTopR, btMidL, btMid, btMidR, btBotL, btBot, btBotR)

        for(btn in buttons){addOnClickListener(btn)}
    }

    private fun addOnClickListener(button: Button){
        button.setOnClickListener {
            if(!tvWinner.isVisible){
                if(button.text.isBlank()){
                    if(playerOneTurn){
                        button.text = "X"
                        if(checkWin()){
                            tvWinner.text = "Player 1 Wins!"
                            tvWinner.isVisible = true
                        }else{
                            playerOneTurn = false
                            cvPlayer2.setBackgroundColor(Color.MAGENTA)
                            cvPlayer1.setBackgroundColor(Color.WHITE)
                        }
                    }else{
                        button.text = "O"
                        if(checkWin()){
                            tvWinner.text = "Player 2 Wins!"
                            tvWinner.isVisible = true
                        }else{
                            playerOneTurn = true
                            cvPlayer1.setBackgroundColor(Color.MAGENTA)
                            cvPlayer2.setBackgroundColor(Color.WHITE)
                        }
                    }
                }else{
                    Toast.makeText(this, "Please choose another tile", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun checkWin(): Boolean{
        if(btTopL.text == btTop.text && btTopL.text == btTopR.text && btTopL.text.isNotBlank()){return true}
        if(btMidL.text == btMid.text && btMidL.text == btMidR.text && btMidL.text.isNotBlank()){return true}
        if(btBotL.text == btBot.text && btBotL.text == btBotR.text && btBotL.text.isNotBlank()){return true}
        if(btTopL.text == btMidL.text && btTopL.text == btBotL.text && btTopL.text.isNotBlank()){return true}
        if(btTop.text == btMid.text && btTop.text == btBot.text && btTop.text.isNotBlank()){return true}
        if(btTopR.text == btMidR.text && btTopR.text == btBotR.text && btTopR.text.isNotBlank()){return true}
        if(btTopL.text == btMid.text && btTopL.text == btBotR.text && btTopL.text.isNotBlank()){return true}
        if(btBotL.text == btMid.text && btBotL.text == btTopR.text && btBotL.text.isNotBlank()){return true}
        return false
    }
}