package com.dimsun.android.roomz

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.dimsun.android.roomz.data.entity.Contact
import com.dimsun.android.roomz.data.local.ContactDao
import com.dimsun.android.roomz.data.local.ContactDatabase
import com.dimsun.android.roomz.util.observeOnce
import junit.framework.Assert.assertEquals
import org.junit.*
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class ContactDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ContactDatabase
    private lateinit var contactDao: ContactDao
    val TAG = "ContactDaoTest"

    @Test
    @Before
    fun setup() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        try {
            database = Room.inMemoryDatabaseBuilder(context, ContactDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        } catch (e: Exception) {
            Log.d(TAG, e.message)
        }
        contactDao = database.contactDao()
    }

    @Test
    @Throws(Exception::class)
    fun writePostAndReadInList() {

        contactDao.getAll().observeOnce {
            assertEquals(0, it.size)
        }

        val newContact = Contact(0, "Jean", "Test", "000000", "jeantest@test.com")
        contactDao.insert(newContact)

        contactDao.getAll().observeOnce {
            assertEquals(1,it.size)
        }
    }

    @Test
    @Throws(Exception::class)
    fun deleteAll() {

        contactDao.getAll().observeOnce {
            assertEquals(0, it.size)
        }

        val newContact = Contact(0, "Jean", "Test", "000000", "jeantest@test.com")
        contactDao.insert(newContact)

        contactDao.getAll().observeOnce {
            assertEquals(1,it.size)
        }

        contactDao.deleteAll()

        contactDao.getAll().observeOnce {
            assertEquals(0,it.size)
        }
    }

    @After
    fun tearDown() {
      database.close()
    }
}
