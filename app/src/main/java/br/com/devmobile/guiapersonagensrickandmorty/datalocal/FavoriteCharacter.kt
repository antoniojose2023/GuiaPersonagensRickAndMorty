package br.com.devmobile.guiapersonagensrickandmorty.datalocal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favorite_character")
data class FavoriteCharacter(
      @PrimaryKey(autoGenerate = true)
      val id: Int,
      val name: String,
      val status: String,
      val image: String
)
