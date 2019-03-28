package com.dimsun.android.roomz.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.dimsun.android.roomz.data.entity.Contact
import kotlinx.coroutines.CoroutineScope

/**
 * Remplace ce que faisait l'OpenHelper SQLite
 *
 * Abstract class car on a rarement besoin de deux instances d'accès à la base de donnée.
 * Une instance est déjà couteuse.
 */
@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ContactDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contact_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}