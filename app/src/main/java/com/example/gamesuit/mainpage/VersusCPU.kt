package com.example.gamesuit.mainpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.gamesuit.R
import com.example.gamesuit.databinding.ActivityVersusCpuBinding
import com.example.gamesuit.databinding.LayoutDialogBinding
import com.example.gamesuit.menupage.PageMenuActivity
import kotlin.random.Random

class VersusCPU : AppCompatActivity() {

    private val binding: ActivityVersusCpuBinding by lazy {
        ActivityVersusCpuBinding.inflate(layoutInflater)
    }

    private val getName: String by lazy {
        intent.getStringExtra("name") ?: "unknown"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Pemain 1
        binding.playerRock.setOnClickListener {
            binding.playerRock.setImageResource(R.mipmap.ic_rock_round)
            Toast.makeText(this, "$getName memilih BATU", Toast.LENGTH_SHORT).show()
            getResult("BATU")
        }

        binding.playerPaper.setOnClickListener {
            binding.playerPaper.setImageResource(R.mipmap.ic_paper_round)
            Toast.makeText(this, "$getName memilih KERTAS", Toast.LENGTH_SHORT).show()
            getResult("KERTAS")
        }

        binding.playerScissors.setOnClickListener {
            binding.playerScissors.setImageResource(R.mipmap.ic_scissors_round)
            Toast.makeText(this, "$getName memilih GUNTING", Toast.LENGTH_SHORT).show()
            getResult("GUNTING")
        }

        // Exit Button
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

    private fun gameReset() {
        binding.playerRock.setImageResource(R.drawable.batu)
        binding.playerPaper.setImageResource(R.drawable.kertas)
        binding.playerScissors.setImageResource(R.drawable.gunting)

        binding.cpuRock.setImageResource(R.drawable.batu)
        binding.cpuPaper.setImageResource(R.drawable.kertas)
        binding.cpuScissors.setImageResource(R.drawable.gunting)
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

    private fun getResult(player1: String) {

        var cpu = ""
        val randomNum = Random.nextInt(3) + 1

        if (randomNum == 1) {
            cpu = "BATU"
        } else if (randomNum == 2) {
            cpu = "KERTAS"
        } else if (randomNum == 3) {
            cpu = "GUNTING"
        }

        if (cpu == "BATU") {
            binding.cpuRock.setImageResource(R.mipmap.ic_rock_round)
            Toast.makeText(this, "CPU Memilih BATU", Toast.LENGTH_SHORT).show()
        } else if (cpu == "KERTAS") {
            binding.cpuPaper.setImageResource(R.mipmap.ic_paper_round)
            Toast.makeText(this, "CPU Memilih KERTAS", Toast.LENGTH_SHORT).show()
        } else if (cpu == "GUNTING") {
            binding.cpuScissors.setImageResource(R.mipmap.ic_scissors_round)
            Toast.makeText(this, "CPU Memilih GUNTING", Toast.LENGTH_SHORT).show()
        }

        // Game Rules
        if (cpu == player1) {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "DRAW!"
        } else if (player1 == "BATU" && cpu == "GUNTING") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 1\nMENANG!"
        } else if (player1 == "BATU" && cpu == "KERTAS") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "CPU\nMENANG!"
        } else if (player1 == "KERTAS" && cpu == "BATU") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 1\nMENANG!"
        } else if (player1 == "KERTAS" && cpu == "GUNTING") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "CPU\nMENANG!"
        } else if (player1 == "GUNTING" && cpu == "KERTAS") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "Pemain 1\nMENANG!"
        } else if (player1 == "GUNTING" && cpu == "BATU") {
            val showDialog = showDialog()
            showDialog.tvDialogResult.text = "CPU\nMENANG!"
        }
    }
}