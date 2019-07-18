package com.dimsun.android.roomz.ui

import android.arch.lifecycle.LiveData
import com.dimsun.android.roomz.data.entity.Contact
import com.dimsun.android.roomz.data.local.ContactRepo

class ContactUseCase(private val repo: ContactRepo) {

    suspend fun getAllContacts(): LiveData<List<Contact>> {
        return repo.getAll()
    }

    suspend fun insertNewContact(contact: Contact) {
        repo.insert(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        repo.deleteContact(contact)
    }

    suspend fun deleteAll() {
        repo.deleteAll()
    }
}
