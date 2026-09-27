package br.com.devmobile.guiapersonagensrickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import br.com.devmobile.guiapersonagensrickandmorty.databinding.ItemPersonagemBinding
import br.com.devmobile.guiapersonagensrickandmorty.model.Result
import com.bumptech.glide.Glide
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory

class AdapterCharacter(
    var onClickCharacter: (Result) -> Unit = {},
    var onClickFavorite: (Result) -> Unit = {},
): RecyclerView.Adapter<AdapterCharacter.ViewHolderCharacter>()  {
    private var results = mutableListOf<Result>()

    fun addLista(lista: MutableList<Result>){
          results.addAll(lista)
          notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacter {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPersonagemBinding.inflate(layoutInflater, parent, false)
        return ViewHolderCharacter( binding )
    }

    override fun onBindViewHolder(holder: ViewHolderCharacter,  position: Int ) {
            val character = results[position]
            holder.bind( character )
    }

    override fun getItemCount() = results.size

    inner class ViewHolderCharacter(val binding: ItemPersonagemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: Result){

                binding.apply {
                      tvNomePersonagem.text = character.name
                      tvStatus.text = character.status
                      tvEspecie.text = character.species
                      tvOrigiem.text = character.origin.name
                }

               Glide.with(binding.root.context).load(character.image).into(binding.ivImagemPersonagem)

               binding.cardItemCharacter.setOnClickListener {
                        onClickCharacter(character)
               }

              binding.ivFavorito.setOnClickListener {
                    onClickFavorite(character)
               }

        }
    }

}