package edu.cascadia.mobas.northcreekforest

import android.content.Context
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import android.util.Log

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import androidx.room.Room
import edu.cascadia.mobas.northcreekforest.db.AppDatabase
import edu.cascadia.mobas.northcreekforest.db.PhotoDao
import edu.cascadia.mobas.northcreekforest.db.PhotoPointDao
import edu.cascadia.mobas.northcreekforest.db.UserDao
import edu.cascadia.mobas.northcreekforest.models.User
import edu.cascadia.mobas.northcreekforest.utilities.SampleData

import org.junit.Assert.assertEquals

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private var aDB: AppDatabase? = null
    private var pDao: PhotoDao? = null
    private var ppDao: PhotoPointDao? = null
    private var uDao: UserDao? = null

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        aDB = Room.inMemoryDatabaseBuilder<AppDatabase>(context, AppDatabase::class.java!!).build()
        pDao = aDB!!.photoDao()
        ppDao = aDB!!.photoPointDao()
        uDao = aDB!!.userDao()
        Log.i(TAG, "create Db")
    }

    @After
    fun closeDb() {
        aDB!!.close()
        Log.i(TAG, "closeDb")
    }

    @Test
    fun createAndRetrieveUsers() {
        uDao!!.addAll(SampleData.users)
        val count = uDao!!.count
        Log.i(TAG, "createAndRetrieveUsers$count")
        assertEquals(SampleData.users.size.toLong(), count.toLong())
    }

    @Test
    fun compareStrings() {
        uDao!!.addAll(SampleData.users)
        val Original = SampleData.users.get(0)
        val fromDb = uDao!!.getUser(1)
        assertEquals(Original.user_Name, fromDb.user_Name)
        assertEquals(1, fromDb.id.toLong())
    }

    companion object {
        val TAG = "Junit"
    }
}
