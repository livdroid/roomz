package com.dimsun.android.roomz.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.dimsun.android.roomz.data.entity.Contact
import com.dimsun.android.roomz.data.local.ContactDatabase
import com.dimsun.android.roomz.data.local.ContactRepo
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

//TODO : delete app reference
// -> DI (Koin/Dagger)
//DI tests
//VM tests
class ContactsViewModel : ViewModel() {

    @Inject
    lateinit var application: Application

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: ContactRepo
    val allContacts: LiveData<List<Contact>>

    init {
        val contactDao = ContactDatabase.getDatabase(application, scope).contactDao()
        repository = ContactRepo(contactDao)
        allContacts = repository.allContacts
    }

    fun insert(contact: Contact): Job = GlobalScope.launch(Dispatchers.IO) {
        repository.insert(contact)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    fun deleteContact(contact: Contact) = GlobalScope.launch(Dispatchers.IO) {
        repository.deleteContact(contact)
    }

    fun deleteAll(): Boolean {
        deleteAllContacts()
        return true
    }

    fun deleteAllContacts() = GlobalScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}
