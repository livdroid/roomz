package com.dimsun.android.roomz.data.local

import android.arch.lifecycle.LiveData
import android.content.Context
import android.support.annotation.WorkerThread
import com.dimsun.android.roomz.data.entity.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainCoroutineDispatcher

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class ContactRepoImpl(private val contactDao: ContactDao) : ContactRepo {

    /**
     * @WorkerThread
     * Doit être appelé pour eviter les crashs dur aux requetes sur l'UI Thread
     * Elle fonctionenra donc dans un thread différent de celui pour l'UI.
     * Une suspend function est une fonction qui peut être en pause et reprendre plus tard.
     */

    @WorkerThread
    override suspend fun getAll(): LiveData<List<Contact>> = contactDao.getAll()

    @WorkerThread
    override suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }

    @WorkerThread
    override suspend fun deleteContact(contact: Contact) {
        contactDao.delete(contact)
    }

    @WorkerThread
    override suspend fun deleteAll() {
        contactDao.deleteAll()
    }
}