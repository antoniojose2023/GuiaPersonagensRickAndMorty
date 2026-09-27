package br.com.devmobile.guiapersonagensrickandmorty.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.LoginFilter
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.devmobile.guiapersonagensrickandmorty.AdapterCharacter
import br.com.devmobile.guiapersonagensrickandmorty.R
import br.com.devmobile.guiapersonagensrickandmorty.databinding.ActivityListagemPersonagensBinding
import br.com.devmobile.guiapersonagensrickandmorty.datalocal.DatabaseRoom
import br.com.devmobile.guiapersonagensrickandmorty.datalocal.FavoriteCharacter
import br.com.devmobile.guiapersonagensrickandmorty.model.Result
import br.com.devmobile.guiapersonagensrickandmorty.repository.RepositryCharacter
import br.com.devmobile.guiapersonagensrickandmorty.util.Status
import br.com.devmobile.guiapersonagensrickandmorty.util.Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.http2.Http2Reader

class ListagemPersonagensActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityListagemPersonagensBinding.inflate(layoutInflater) }

    private var adapterCharacter = AdapterCharacter()

    private val reppsitoryCharacter by lazy {
        RepositryCharacter()
    }

    private var pageAtual = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val favoriteDB = DatabaseRoom.getInstance( this )
        val favoriteCharacterDAO = favoriteDB.favoriteCharacterDao()


        binding.rvPersonagens.layoutManager = LinearLayoutManager(this)
        binding.rvPersonagens.adapter = adapterCharacter

        binding.rvPersonagens.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if(!recyclerView.canScrollVertically(1)){
                    binding.progressBar.visibility = View.VISIBLE
                    Handler(Looper.getMainLooper()).postDelayed({
                        getListCharacterNextPage()
                    },1000)

                }

            }
        })

        binding.searchViewPesquisa.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(textoPesquisa: String?): Boolean {

                    getListCharacter( textoPesquisa!! )

                return true
            }

            override fun onQueryTextSubmit(textoPesquisa: String?): Boolean {

                    getListCharacter( textoPesquisa!! )

                return true
            }
        })



        adapterCharacter.onClickCharacter = { character ->
              val intent = Intent(this, DetalhePersonagemActivity::class.java)
              intent.putExtra("character", character)
              startActivity(intent)
        }

        adapterCharacter.onClickFavorite = { character ->
             val favoriteCharacter = FavoriteCharacter(0, character.name, character.status, character.image)

             CoroutineScope(Dispatchers.IO).launch {
                val retorno = favoriteCharacterDAO.salvar( favoriteCharacter )

                withContext(Dispatchers.Main){
                      if(retorno > 0){
                          Toast.makeText(applicationContext, "Salvo nos favoritos", Toast.LENGTH_SHORT).show()
                      }else{
                          Toast.makeText(applicationContext, "Erro ao tentar favoritar", Toast.LENGTH_SHORT).show()
                      }
                }
             }


        }


    }

    override fun onStart() {
        super.onStart()
        getListCharacter()
    }

    fun getListCharacterNextPage(){
         if(pageAtual <= Util.COUNT_PAGES){
              getListCharacter( pages = pageAtual )
              pageAtual++
         }

         binding.progressBar.visibility = View.GONE
    }

    fun getListCharacter(nome: String="", pages: Int = 1){
           if(nome.isEmpty() && pages <= 0){
               reppsitoryCharacter.getListCharacter().observe(this){ status ->

                   when(status){
                       is Status.loader -> {  binding.progressBar.visibility = View.VISIBLE }
                       is Status.OnSucess -> {
                           popularRecyclerView(status.list as MutableList<Result>)
                           binding.progressBar.visibility = View.GONE
                       }
                       is Status.OnError -> {
                           Toast.makeText(applicationContext, "Erro - ${status.mensagem}", Toast.LENGTH_SHORT).show()
                           binding.progressBar.visibility = View.GONE

                       }
                   }
               }
           }else{
               reppsitoryCharacter.getListCharacter(nome, pages).observe(this){ status ->

                   when(status){
                       is Status.loader -> {binding.progressBar.visibility = View.VISIBLE}
                       is Status.OnSucess -> {
                           popularRecyclerView(status.list as MutableList<Result>)
                           binding.progressBar.visibility = View.GONE
                       }
                       is Status.OnError -> {
                           Toast.makeText(applicationContext, "Erro - ${status.mensagem}", Toast.LENGTH_SHORT).show()
                           binding.progressBar.visibility = View.GONE
                       }
                   }
               }
           }

    }

    fun popularRecyclerView(lista: MutableList<Result>){
          if(lista.isEmpty()){
               binding.layoutEmptyState.visibility = View.VISIBLE
               binding.rvPersonagens.visibility = View.GONE

          }else{
              binding.layoutEmptyState.visibility = View.GONE
              binding.rvPersonagens.visibility = View.VISIBLE
              adapterCharacter.addLista(lista)
          }
    }

}