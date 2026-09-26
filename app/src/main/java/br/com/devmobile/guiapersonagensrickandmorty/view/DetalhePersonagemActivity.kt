package br.com.devmobile.guiapersonagensrickandmorty.view

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.devmobile.guiapersonagensrickandmorty.AdapterCharacter
import br.com.devmobile.guiapersonagensrickandmorty.R
import br.com.devmobile.guiapersonagensrickandmorty.databinding.ActivityDetalhePersonagemBinding
import br.com.devmobile.guiapersonagensrickandmorty.model.Result
import com.bumptech.glide.Glide

class DetalhePersonagemActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityDetalhePersonagemBinding.inflate(layoutInflater) }

    private lateinit var character: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras

        if(bundle != null){
             character = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                      bundle.getSerializable("character", Result::class.java) as Result
             }else{
                      bundle.getSerializable("character") as Result
             }

             populaTelaDetalhes(character)
        }

        binding.imageButtonVoltar.setOnClickListener {
               finish()
        }

    }

    fun populaTelaDetalhes(character: Result){

        binding.apply {
             tvNomePersongemTopoDetalhesCard.text = character.name

             btStatus.text = character.status
             btEspecie.text = character.species
             btOrigem.text = character.origin.name

             tvStatusDetalhes.text = character.status
             tvLocal.text = character.location.name
             tvGenderDetalhes.text=  character.gender
             tvTypeDetalhes.text = character.type

            Glide.with(applicationContext).load(character.image).into(ivImagemPersonagemDetalhes)
        }

    }

}