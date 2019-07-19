package com.dimsun.android.roomz.data.local

import androidx.lifecycle.LiveData
import com.dimsun.android.roomz.data.entity.Contact

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class ContactRepoImpl(private val contactDao: ContactDao) : ContactRepo {


    override suspend fun getAll(): LiveData<List<Contact>> = contactDao.getAll()

    override suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }

    override suspend fun deleteContact(contact: Contact) {
        contactDao.delete(contact)
    }

    override suspend fun deleteAll() {
        contactDao.deleteAll()
    }
}