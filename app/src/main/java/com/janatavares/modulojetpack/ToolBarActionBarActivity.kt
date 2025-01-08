package com.janatavares.modulojetpack

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.janatavares.modulojetpack.databinding.ActivityToolBarActionBarBinding

class ToolBarActionBarActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityToolBarActionBarBinding.inflate(layoutInflater)
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

        //supportActionBar?.hide()
        //inicializarActionBar()

        inicializarToolBar()
    }

    private fun inicializarToolBar() {

        binding.tbPrincipal.title = "Youtube"
        binding.tbPrincipal.setTitleTextColor(getColor(R.color.white))
        binding.tbPrincipal.inflateMenu(R.menu.action_bar_exemple)
        binding.tbPrincipal.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.item_adicionar -> {
                    Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_pesquisar -> {
                    Toast.makeText(this, "Pesquisar", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_config -> {
                    Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.item_sair -> {
                    Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                else -> {
                    return@setOnMenuItemClickListener true
                }
            }
        }
        //binding.tbPrincipal.subtitle = "Videos"

        //setSupportActionBar(binding.tbPrincipal)
        //inicializarActionBar()
    }

    private fun inicializarActionBar() {
        addMenuProvider(
            object : MenuProvider{
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.action_bar_exemple, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when(menuItem.itemId){
                        R.id.item_adicionar -> {
                            Toast.makeText(applicationContext, "Adicionar", Toast.LENGTH_SHORT).show()
                        }
                        R.id.item_pesquisar -> {
                            Toast.makeText(applicationContext, "Pesquisar", Toast.LENGTH_SHORT).show()
                        }
                        R.id.item_config -> {
                            Toast.makeText(applicationContext, "Configurações", Toast.LENGTH_SHORT).show()
                        }
                        R.id.item_sair -> {
                            Toast.makeText(applicationContext, "Sair", Toast.LENGTH_SHORT).show()
                        }
                    }
                    return true
                }

            }
        )
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_adicionar -> {
                Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
            }
            R.id.item_pesquisar -> {
                Toast.makeText(this, "Pesquisar", Toast.LENGTH_SHORT).show()
            }
            R.id.item_config -> {
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            }
            R.id.item_sair -> {
                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }*/
}