package br.com.devmobile.guiapersonagensrickandmorty.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.devmobile.guiapersonagensrickandmorty.AdapterCharacter
import br.com.devmobile.guiapersonagensrickandmorty.R
import br.com.devmobile.guiapersonagensrickandmorty.databinding.ActivityListagemPersonagensBinding
import br.com.devmobile.guiapersonagensrickandmorty.model.Result
import br.com.devmobile.guiapersonagensrickandmorty.repository.RepositryCharacter
import br.com.devmobile.guiapersonagensrickandmorty.util.Status
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListagemPersonagensActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityListagemPersonagensBinding.inflate(layoutInflater) }

    private var adapterCharacter = AdapterCharacter()

    private val reppsitoryCharacter by lazy {
        RepositryCharacter()
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

        adapterCharacter.onClickCharacter = { character ->
              val intent = Intent(this, DetalhePersonagemActivity::class.java)
              intent.putExtra("character", character)
              startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        getListCharacter()
    }

    fun getListCharacter(){
        reppsitoryCharacter.getListCharacter().observe(this){ status ->

            when(status){
                is Status.loader -> {}
                is Status.OnSucess -> {
                      binding.rvPersonagens.layoutManager = LinearLayoutManager(this)
                      adapterCharacter.addLista(status.list as MutableList<Result>)
                      binding.rvPersonagens.adapter = adapterCharacter
                }
                is Status.OnError -> {
                      Toast.makeText(applicationContext, "Erro - ${status.mensagem}", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }

}