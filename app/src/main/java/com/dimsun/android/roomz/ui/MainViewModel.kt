package com.dimsun.android.roomz.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dimsun.android.roomz.data.entity.Contact
import com.dimsun.android.roomz.util.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val contactUseCase: ContactUseCase,
                        private val navigation: Navigation
) : ViewModel(), CoroutineScope {

    private var parentJob = Job()
    override val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private var _allContacts: LiveData<List<Contact>> = MutableLiveData()
    val allContacts: LiveData<List<Contact>> get() = _allContacts

    init {
        _allContacts = contactUseCase.getAllContacts()
    }

    private fun insert(contact: Contact) {
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

    private fun deleteAllContacts() {
        launch {
            contactUseCase.deleteAll()
        }
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    fun insertSampleContact() {
        insert(
            Contact(
                0,
                "Jane",
                "Doe",
                "09 02 03 02 92",
                "jane.doe@ada.com"
            )
        )
    }

    fun showInsertView() {
        navigation.goToInsertActivity()
    }
}