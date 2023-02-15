package com.example.gamesuit.menupage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gamesuit.databinding.ActivityPageMenuBinding
import com.example.gamesuit.mainpage.VersusCPU
import com.example.gamesuit.mainpage.VersusPlayer
import com.google.android.material.snackbar.Snackbar

class PageMenuActivity : AppCompatActivity() {

    private val binding: ActivityPageMenuBinding by lazy {
        ActivityPageMenuBinding.inflate(layoutInflater)
    }

    private val getName: String by lazy {
        intent.getStringExtra("name") ?: "unknown"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvMenu1.text = "$getName vs Pemain"
        binding.tvMenu2.text = "$getName vs CPU"

        val snackBar =
            Snackbar.make(binding.root, "Selamat Datang $getName", Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("Tutup") {
            snackBar.dismiss()
        }
        snackBar.show()

        binding.ivMenu1.setOnClickListener {
            val intent = Intent(this, VersusPlayer::class.java)
            intent.putExtra("name", getName)
            startActivity(intent)
        }

        binding.ivMenu2.setOnClickListener {
            val intent = Intent(this, VersusCPU::class.java)
            intent.putExtra("name", getName)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Keluar dari Permainan", Toast.LENGTH_SHORT).show()
    }
}