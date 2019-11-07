package edu.cascadia.mobas.northcreekforest

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import edu.cascadia.mobas.northcreekforest.db.AppDatabase
import edu.cascadia.mobas.northcreekforest.models.User

class ActivityAccountViewModel(application: Application) : AndroidViewModel(application) {

    private val appDatabase: AppDatabase

    init {

        appDatabase = AppDatabase.getInstance(getApplication())
    }

    fun addUser(user: User) {
        addAsyncTask(appDatabase).execute(user)
    }

    private class addAsyncTask internal constructor(private val db: AppDatabase) : AsyncTask<User, Void, Void>() {

        override fun doInBackground(vararg users: User): Void? {
            db.userDao().addUser(users[0])
            return null
        }
    }


}
