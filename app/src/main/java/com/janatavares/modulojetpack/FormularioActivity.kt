package com.janatavares.modulojetpack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.janatavares.modulojetpack.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){
            /*btEnviar.setOnClickListener {
                //checkbox()
            }*/

            /*cbPoliticas.setOnClickListener {
                checkbox()
            }
            cbEmail.setOnClickListener {
                checkbox()
            }*/

            cbPoliticas.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if(isChecked) "checked" else "unchecked"
                textResultado.text = "Politicas: $resultado"
            }
            cbEmail.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if(isChecked) "checked" else "unchecked"
                textResultado.text = "Email: $resultado"
            }
        }

    }

    /*private fun checkbox() {
        val politicas = binding.cbPoliticas.isChecked
        val email = binding.cbEmail.isChecked
        binding.textResultado.text = "Politicas: $politicas, Email: $email"
    }*/
}