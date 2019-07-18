package com.dimsun.android.roomz.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.dimsun.android.roomz.data.entity.Contact

/**
 * Remplace ce que faisait l'OpenHelper SQLite
 *
 * Abstract class car on a rarement besoin de deux instances d'accès à la base de donnée.
 * Une instance est déjà couteuse.
 */

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao
}