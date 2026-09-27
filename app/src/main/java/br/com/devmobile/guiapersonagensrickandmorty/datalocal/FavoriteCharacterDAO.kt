package br.com.devmobile.guiapersonagensrickandmorty.datalocal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
@JvmSuppressWildcards
interface FavoriteCharacterDAO {

    @Insert
    suspend fun salvar(character: FavoriteCharacter): Long

    @Delete
    suspend fun delete(character: FavoriteCharacter): Int

}