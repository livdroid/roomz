package com.dimsun.android.roomz.data.local

import androidx.lifecycle.LiveData
import com.dimsun.android.roomz.data.entity.Contact

interface ContactRepo {
    fun getAll(): LiveData<List<Contact>>
    suspend fun insert(contact: Contact)
    suspend fun deleteContact(contact: Contact)
    suspend fun deleteAll()
}