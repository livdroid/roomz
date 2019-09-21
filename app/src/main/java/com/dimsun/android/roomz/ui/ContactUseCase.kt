package com.dimsun.android.roomz.ui

import android.content.Context
import androidx.lifecycle.LiveData
import com.dimsun.android.roomz.data.entity.Contact
import com.dimsun.android.roomz.data.local.ContactDatabase
import com.dimsun.android.roomz.data.local.ContactRepoImpl

class ContactUseCase(context: Context) {

    private val repo: ContactRepoImpl

    init {
        val contactDao = ContactDatabase.getDatabase(context).contactDao()
        repo = ContactRepoImpl(contactDao)
    }

    fun getAllContacts(): LiveData<List<Contact>> {
        return repo.getAll()
    }

    suspend fun insertNewContact(firstName: String,
                                 lastName: String,
                                 number: String,
                                 email: String) {
        repo.insert(Contact(
            firstname = firstName,
            lastname = lastName,
            number = number,
            email = email,
            uid = 0
        ))
    }

    suspend fun deleteContact(contact: Contact) {
        repo.deleteContact(contact)
    }

    suspend fun deleteAll() {
        repo.deleteAll()
    }
}