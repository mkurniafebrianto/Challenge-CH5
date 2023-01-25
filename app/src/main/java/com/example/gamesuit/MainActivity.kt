package com.example.gamesuit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var imgRockPlayer: ImageView
    lateinit var imgRockCOM: ImageView
    lateinit var imgPaperPlayer: ImageView
    lateinit var imgPaperCOM: ImageView
    lateinit var imgScissorsPlayer: ImageView
    lateinit var imgScissorsCOM: ImageView
    lateinit var imgRefresh: ImageView
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgRockPlayer = findViewById(R.id.pemain_batu)
        imgRockCOM = findViewById(R.id.com_batu)
        imgPaperPlayer = findViewById(R.id.pemain_kertas)
        imgPaperCOM = findViewById(R.id.com_kertas)
        imgScissorsPlayer = findViewById(R.id.pemain_gunting)
        imgScissorsCOM = findViewById(R.id.com_gunting)
        imgRefresh = findViewById(R.id.refresh_btn)
        tvResult = findViewById(R.id.tv_result)

        imgRockPlayer.setOnClickListener {
            imgRockPlayer.setImageResource(R.mipmap.ic_rock_round)
            val message = gamestart("batu")
            Toast.makeText(this, "Pemain 1 memilih " + message, Toast.LENGTH_SHORT).show()
        }

        imgPaperPlayer.setOnClickListener {
            imgPaperPlayer.setImageResource(R.mipmap.ic_paper_round)
            val message = gamestart("kertas")
            Toast.makeText(this, "Pemain 1 memilih " + message, Toast.LENGTH_SHORT).show()
        }

        imgScissorsPlayer.setOnClickListener {
            imgScissorsPlayer.setImageResource(R.mipmap.ic_scissors_round)
            val message = gamestart("gunting")
            Toast.makeText(this, "Pemain 1 memilih " + message, Toast.LENGTH_SHORT).show()
        }

        imgRefresh.setOnClickListener {
            imgRockPlayer.setImageResource(R.drawable.batu)
            imgPaperPlayer.setImageResource(R.drawable.kertas)
            imgScissorsPlayer.setImageResource(R.drawable.gunting)
            imgRockCOM.setImageResource(R.drawable.batu)
            imgPaperCOM.setImageResource(R.drawable.kertas)
            imgScissorsCOM.setImageResource(R.drawable.gunting)
            tvResult.text = ""
        }

    }

    private fun gamestart(player: String):String {

        var COM = ""
        val randomNum = Random.nextInt(3) + 1

        if (randomNum ==  1) {
            COM = "batu"
        } else if (randomNum ==  2) {
            COM = "kertas"
        } else if (randomNum == 3) {
            COM = "gunting"
        }

        if (COM == "batu") {
            imgRockCOM.setImageResource(R.mipmap.ic_rock_round)
        } else if (COM == "kertas") {
            imgPaperCOM.setImageResource(R.mipmap.ic_paper_round)
        } else if (COM == "gunting") {
            imgScissorsCOM.setImageResource(R.mipmap.ic_scissors_round)
        }

        // Game Rules
        if (COM == player) {
            tvResult.text = "DRAW!"
        } else if (player == "batu" && COM == "gunting") {
            tvResult.text = "Pemain 1\nMENANG!"
        } else if (player == "batu" && COM == "kertas") {
            tvResult.text = "Komputer\nMENANG!"
        } else if (player == "kertas" && COM == "batu") {
            tvResult.text = "Pemain 1\nMENANG!"
        } else if (player == "kertas" && COM == "gunting") {
            tvResult.text = "Komputer\nMENANG!"
        } else if (player == "gunting" && COM == "kertas") {
            tvResult.text = "Pemain 1\nMENANG!"
        } else if (player == "gunting" && COM == "batu") {
            tvResult.text = "Komputer\nMENANG!"
        }

        return player.uppercase()
    }
}