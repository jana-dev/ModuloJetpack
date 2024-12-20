package com.janatavares.modulojetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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
            btEnviar.setOnClickListener {
                //checkbox()
                //radioButton()
                //exibirSnackBar()
                caixaDialogoAlerta()
            }

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

            switchNotificacoes.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if(isChecked) "checked" else "unchecked"
                textResultado.text = "Notificações: $resultado"
            }
        }

    }

    private fun caixaDialogoAlerta() {

        //Também da pra fazer com encadeamento de métodos
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Confirmar envio?")
        alertBuilder.setMessage("Após confirmar não será possível desfazer a ação.")
        alertBuilder.setNegativeButton("Cancelar"){
            dialog, _ -> dialog.dismiss()
        }

        alertBuilder.setPositiveButton("Confirmar") { _, _ ->
            Toast.makeText(this, "Formulario enviado", Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setCancelable(false)

        val alertDialog = alertBuilder.create()
        alertDialog.show()

    }

    private fun exibirSnackBar() {
        val snackBar = Snackbar.make(binding.root, "Formulario enviado", Snackbar.LENGTH_SHORT)
        snackBar.setAction("Desfazer"){
            Snackbar.make(binding.root, "Formulário desfeito", Snackbar.LENGTH_SHORT).show()
        }
        snackBar.show()
    }

    private fun radioButton() {

        val genero = when(binding.rgGenero.checkedRadioButtonId){
            binding.rbFeminino.id -> "Feminino"
            binding.rbMasculino.id -> "Masculino"
            else -> "Não informado"
        }
        binding.textResultado.text = "Genero: $genero"
        binding.rgGenero.clearCheck()
    }

    /*private fun checkbox() {
        val politicas = binding.cbPoliticas.isChecked
        val email = binding.cbEmail.isChecked
        binding.textResultado.text = "Politicas: $politicas, Email: $email"
    }*/
}