package com.dimsun.android.roomz

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.dimsun.android.roomz.data.entity.Contact
import com.dimsun.android.roomz.data.local.ContactDao
import com.dimsun.android.roomz.data.local.ContactDatabase
import com.dimsun.android.roomz.util.observeOnce
import junit.framework.Assert.assertEquals
import org.junit.*
import org.junit.runner.RunWith
import java.lang.Exception

/*
    ***** Not Working Anymore *****
    Not updated since androidx and room 2 migration
 */
/*
@RunWith(AndroidJUnit4::class)
class ContactDaoTest {

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

    @Test
    @Throws(Exception::class)
    fun deleteContact() {

        contactDao.getAll().observeOnce {
            assertEquals(0, it.size)
        }

        val newContact = Contact(0, "Jean", "Test", "000000", "jeantest@test.com")
        contactDao.insert(newContact)

        contactDao.getAll().observeOnce {
            assertEquals(1,it.size)
        }

        contactDao.delete(newContact)

        contactDao.getAll().observeOnce {
            assertEquals(0,it.size)
        }
    }

    @Test
    @Throws(Exception::class)
    fun fetchedListShouldBeEmpty() {

        contactDao.getAll().observeOnce {
            assertEquals(0, it.size)
        }
    }

    @After
    fun tearDown() {
      database.close()
    }
}
        */