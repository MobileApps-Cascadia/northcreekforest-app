package edu.cascadia.mobas.northcreekforest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import android.media.Image
import android.os.AsyncTask

import java.sql.Blob
import edu.cascadia.mobas.northcreekforest.db.AppDatabase
import edu.cascadia.mobas.northcreekforest.models.Photo

class UploadViewModel(application: Application) : AndroidViewModel(application) {

    private val appDatabase: AppDatabase

    var apprepo: AppRepository? = null

    init {


        appDatabase = AppDatabase.getInstance(getApplication())

    }


    fun addPhoto(photos: Photo) {

        addAsyncTask(appDatabase).execute(photos)


    }


    private class addAsyncTask internal constructor(private val db: AppDatabase) : AsyncTask<Photo, Void, Void>() {


        override fun doInBackground(vararg photos: Photo): Void? {
            db.photoDao().addPhoto(photos[0])
            return null
        }

    }
}