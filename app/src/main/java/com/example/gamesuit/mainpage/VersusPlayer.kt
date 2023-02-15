package com.example.gamesuit.mainpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.gamesuit.R
import com.example.gamesuit.databinding.ActivityVersusPlayerBinding
import com.example.gamesuit.databinding.LayoutDialogBinding
import com.example.gamesuit.menupage.PageMenuActivity

class VersusPlayer : AppCompatActivity() {

    private val binding: ActivityVersusPlayerBinding by lazy {
        ActivityVersusPlayerBinding.inflate(layoutInflater)
    }

    private val getName: String by lazy {
        intent.getStringExtra("name") ?: "unknown"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Pemain 1
        binding.player1Rock.setOnClickListener {
            binding.player1Rock.setImageResource(R.mipmap.ic_rock_round)
            Toast.makeText(this, "$getName memilih BATU", Toast.LENGTH_SHORT).show()
            getResult("BATU")
        }


        binding.player1Paper.setOnClickListener {
            binding.player1Paper.setImageResource(R.mipmap.ic_paper_round)
            Toast.makeText(this, "$getName memilih KERTAS", Toast.LENGTH_SHORT).show()
            getResult("KERTAS")
        }

        binding.player1Scissors.setOnClickListener {
            binding.player1Scissors.setImageResource(R.mipmap.ic_scissors_round)
            Toast.makeText(this, "$getName memilih GUNTING", Toast.LENGTH_SHORT).show()
            getResult("GUNTING")
        }
        //

        // Refresh Button
        binding.btnRefresh.setOnClickListener {
            gameReset()
        }
        //

        // Exit Button
        binding.btnExit.setOnClickListener {
            val intent = Intent(this, PageMenuActivity::class.java)
            intent.putExtra("name", getName)
            startActivity(intent)
        }
        //
    }


    private fun showDialog(): LayoutDialogBinding {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setCancelable(false)

        val view = layoutInflater.inflate(R.layout.layout_dialog, null, false)
        val dialogBinding = LayoutDialogBinding.bind(view)
        dialogBuilder.setView(view)

        dialogBinding.btnKembaliMenu.setOnClickListener {
            val intent = Intent(this, PageMenuActivity::class.java)
            intent.putExtra("name", getName)
            startActivity(intent)
        }

        val dialog = dialogBuilder.create()
        dialogBinding.btnMainLagi.setOnClickListener {
            gameReset()
            dialog.dismiss()
        }

        dialog.dismiss()
        dialog.show()

        return dialogBinding
    }

    private fun gameRules(player1: String, player2: String) {
        // Game Rules
        if (player1 == player2) {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "DRAW"
        } else if (player1 == "BATU" && player2 == "GUNTING") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 1\nMENANG!"
        } else if (player1 == "BATU" && player2 == "KERTAS") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 2\nMENANG!"
        } else if (player1 == "KERTAS" && player2 == "BATU") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 1\nMENANG!"
        } else if (player1 == "KERTAS" && player2 == "GUNTING") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 2\nMENANG!"
        } else if (player1 == "GUNTING" && player2 == "KERTAS") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 1\nMENANG!"
        } else if (player1 == "GUNTING" && player2 == "BATU") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 2\nMENANG!"
        }
    }

    private fun getResult(player1: String) {
        // Pemain 2
        binding.player2Rock.setOnClickListener {
            val player2 = "BATU"
            binding.player2Rock.setImageResource(R.mipmap.ic_rock_round)
            Toast.makeText(this, "Pemain 2 memilih $player2", Toast.LENGTH_SHORT).show()
            gameRules(player1, player2)
        }

        binding.player2Paper.setOnClickListener {
            val player2 = "KERTAS"
            binding.player2Paper.setImageResource(R.mipmap.ic_paper_round)
            Toast.makeText(this, "Pemain 2 memilih $player2", Toast.LENGTH_SHORT).show()
            gameRules(player1, player2)
        }

        binding.player2Scissors.setOnClickListener {
            val player2 = "GUNTING"
            binding.player2Scissors.setImageResource(R.mipmap.ic_scissors_round)
            Toast.makeText(this, "Pemain 2 memilih $player2", Toast.LENGTH_SHORT).show()
            gameRules(player1, player2)
        }
        //
    }

    private fun gameReset() {
        binding.player1Rock.setImageResource(R.drawable.batu)
        binding.player1Paper.setImageResource(R.drawable.kertas)
        binding.player1Scissors.setImageResource(R.drawable.gunting)

        binding.player2Rock.setImageResource(R.drawable.batu)
        binding.player2Paper.setImageResource(R.drawable.kertas)
        binding.player2Scissors.setImageResource(R.drawable.gunting)
    }
}