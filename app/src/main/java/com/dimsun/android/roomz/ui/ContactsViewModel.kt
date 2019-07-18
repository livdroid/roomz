package com.dimsun.android.roomz.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.dimsun.android.roomz.data.entity.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ContactsViewModel(private val contactUseCase: ContactUseCase) : ViewModel(), CoroutineScope {

    private var parentJob = Job()
    override val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO

    private var _allContacts: LiveData<List<Contact>> = MutableLiveData()
    val allContacts: LiveData<List<Contact>> get() = _allContacts

    init {
        launch {
            _allContacts = contactUseCase.getAllContacts()
        }
    }

    fun insert(contact: Contact) {
        launch {
            contactUseCase.insertNewContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        launch {
            contactUseCase.deleteContact(contact)
        }
    }

    fun deleteAll(): Boolean {
        deleteAllContacts()
        return true
    }

    private fun deleteAllContacts()  {
        launch {
            contactUseCase.deleteAll()
        }
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    fun insertSampleContact() {
        insert( Contact(
            0,
            "Jane",
            "Doe",
            "09 02 03 02 92",
            "jane.doe@ada.com"
        ))
    }
}