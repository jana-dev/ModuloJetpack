package com.janatavares.modulojetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.janatavares.modulojetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*binding.btnExecutar?.setOnClickListener {
            Toast.makeText(this, "Executando", Toast.LENGTH_SHORT).show()
        }

        binding.btnClique?.setOnClickListener {
            Toast.makeText(this, "Clicou", Toast.LENGTH_SHORT).show()
        }*/

        with(binding) {
            btnExecutar?.setOnClickListener {
                Toast.makeText(this@MainActivity, "Executando", Toast.LENGTH_SHORT).show()
            }
            btnClique?.setOnClickListener {
                Toast.makeText(this@MainActivity, "Clicou", Toast.LENGTH_SHORT).show()
            }

        }
    }
}