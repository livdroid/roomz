package com.dimsun.android.roomz.data.local

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.dimsun.android.roomz.data.entity.Contact

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class ContactRepo(private val contactDao: ContactDao) {

    /**
     * Toutes les requêtes sont effectuées dans leur propre thread
     * LiveData indiquera à l'observer d'un changement de data
     */
    val allContacts: LiveData<List<Contact>> = contactDao.getAll()

    /**
     * @WorkerThread
     * Doit être appelé pour eviter les crashs dur aux requetes sur l'UI Thread
     * Elle fonctionenra donc dans un thread différent de celui pour l'UI.
     * Une suspend function est une fonction qui peut être en pause et reprendre plus tard.
     */

    @WorkerThread
    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }

    @WorkerThread
    suspend fun deleteContact(contact: Contact) {
        contactDao.delete(contact)
    }

    @WorkerThread
    suspend fun deleteAll() {
        contactDao.deleteAll()
    }
}