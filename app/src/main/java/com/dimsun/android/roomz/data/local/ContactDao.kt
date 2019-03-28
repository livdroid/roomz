package com.dimsun.android.roomz.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.dimsun.android.roomz.data.entity.Contact

/**
 * @Dao
 *
 *Effectue les requetes de lecture/ecriture de la base de donnée.
 *
 */
@Dao
interface ContactDao {

    @Query("SELECT * FROM contact_table")
    fun getAll(): LiveData<List<Contact>>

    @Delete
    fun delete(contact: Contact)

    @Insert
    fun insert(contact: Contact)

    @Query("DELETE FROM contact_table")
    fun deleteAll()
}