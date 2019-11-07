package edu.cascadia.mobas.northcreekforest

import android.app.Application

import androidx.lifecycle.LiveData
import android.os.AsyncTask

import edu.cascadia.mobas.northcreekforest.db.AppDatabase
import edu.cascadia.mobas.northcreekforest.db.PhotoPointDao
import edu.cascadia.mobas.northcreekforest.db.PhotoDao
import edu.cascadia.mobas.northcreekforest.db.UserDao
import edu.cascadia.mobas.northcreekforest.models.Photo
import edu.cascadia.mobas.northcreekforest.models.PhotoPoints
import edu.cascadia.mobas.northcreekforest.models.User

class AppRepository(application: Application) {

    private val photoDao: PhotoDao
    private val photoPointDao: PhotoPointDao
    private val userDao: UserDao
    private val allPhotos: LiveData<List<Photo>>? = null
    private val allPhotoPoints: LiveData<List<PhotoPoints>>? = null
    private val allUsers: LiveData<List<User>>? = null

    init {
        val database = AppDatabase.getInstance(application)

        photoDao = database.photoDao()
        photoPointDao = database.photoPointDao()
        userDao = database.userDao()
    }

    //these method are the API that the repository exposes to the out side. ViewModel calls them
    // the abstraction layer
    fun insert(photo: Photo) {
        InsertPhotoAsyncTask(photoDao).execute(photo)
    }

    fun insert(photoPoints: PhotoPoints) {
        InsertPhotoPointAsyncTask(photoPointDao).execute(photoPoints)
    }

    fun insert(user: User) {
        InsertUserAsyncTask(userDao).execute(user)
    }

    //Room does ont allow database operation on the main thread so we use
    // async tasks to take care of this in a background thread
    private class InsertPhotoAsyncTask constructor(private val photoDao: PhotoDao) : AsyncTask<Photo, Void, Void>() {

        override fun doInBackground(vararg photos: Photo): Void? {
            photoDao.addPhoto(photos[0])
            return null
        }
    }

    private class InsertPhotoPointAsyncTask constructor(private val photoPointDao: PhotoPointDao) : AsyncTask<PhotoPoints, Void, Void>() {

        override fun doInBackground(vararg photoPoints: PhotoPoints): Void? {
            photoPointDao.addPhotoPoint(photoPoints[0])
            return null
        }
    }

    private class InsertUserAsyncTask constructor(private val userDao: UserDao) : AsyncTask<User, Void, Void>() {

        override fun doInBackground(vararg users: User): Void? {
            userDao.addUser(users[0])
            return null
        }
    }
}
