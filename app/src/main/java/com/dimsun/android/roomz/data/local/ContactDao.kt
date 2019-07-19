package com.dimsun.android.roomz.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dimsun.android.roomz.data.entity.Contact

/**
 * @Dao
 *Effectue les requetes de lecture/ecriture de la base de donnée.
 */
@Dao
interface ContactDao {

    //@Query("SELECT * FROM contact_table")
    //suspend fun getAll(): LiveData<List<Contact>>

    @Delete
    fun delete(contact: Contact)

    @Query("DELETE FROM contact_table")
    fun deleteAll()

    @Insert
    fun insert(contact: Contact)

    @Query("SELECT * FROM contact_table")
    fun getAll(): LiveData<List<Contact>>
}