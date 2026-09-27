package br.com.devmobile.guiapersonagensrickandmorty.datalocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FavoriteCharacter::class], version = 1)
abstract class DatabaseRoom: RoomDatabase() {

   abstract fun favoriteCharacterDao(): FavoriteCharacterDAO

   companion object{
       fun getInstance(context: Context): DatabaseRoom{
          return Room.databaseBuilder(
                 context,
              DatabaseRoom::class.java,
                 "favoriteDB"
           ).build()
       }

   }

}