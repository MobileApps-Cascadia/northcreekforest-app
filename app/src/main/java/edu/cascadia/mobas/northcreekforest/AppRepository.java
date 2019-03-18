package edu.cascadia.mobas.northcreekforest;

import android.app.Application;

import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import edu.cascadia.mobas.northcreekforest.db.AppDatabase;
import edu.cascadia.mobas.northcreekforest.db.PhotoPointDao;
import edu.cascadia.mobas.northcreekforest.db.PhotoDao;
import edu.cascadia.mobas.northcreekforest.db.UserDao;
import edu.cascadia.mobas.northcreekforest.models.Photo;
import edu.cascadia.mobas.northcreekforest.models.PhotoPoints;
import edu.cascadia.mobas.northcreekforest.models.User;


public class AppRepository {


   private PhotoDao      photoDao;
   private PhotoPointDao photoPointDao;
   private UserDao       userDao;
   private LiveData<List<Photo>>       allPhotos;
   private LiveData<List<PhotoPoints>> allPhotoPoints;
   private LiveData<List<User>>        allUsers;



    public AppRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        photoDao        = database.photoDao();
        photoPointDao   = database.photoPointDao();
        userDao         = database.userDao();
       // allPhotos       = photoDao.getAllPhotos();
       // allPhotoPoints  = photoPointDao.getAllPhotoPoints();
        //allUsers        = userDao.getAllUsers();

    }

    //these method are the API that the repository exposes to the out side. ViewModel calls them
    // the abstraction layer

    public void insert(Photo photo) {new InsertPhotoAsyncTask(photoDao).execute(photo);}

    public void insert(PhotoPoints photoPoints) {new InsertPhotoPointAsyncTask(photoPointDao).execute(photoPoints);}

    public void insert(User user) {new InsertUserAsyncTask(userDao).execute(user);}


    //Room does ont allow database operation on the main thread so we use
    // async tasks to take care of this in a background thread
    private static class InsertPhotoAsyncTask extends AsyncTask<Photo, Void ,Void>{
        private PhotoDao photoDao;

        private InsertPhotoAsyncTask(PhotoDao photoDao) {this.photoDao = photoDao;}

        @Override
        protected  Void doInBackground(Photo... photos)
        {
            photoDao.addPhoto(photos[0]);
            return null;
        }
    }
    private static class InsertPhotoPointAsyncTask extends AsyncTask<PhotoPoints, Void ,Void>{
        private PhotoPointDao photoPointDao;

        private InsertPhotoPointAsyncTask(PhotoPointDao photoPointDao) {this.photoPointDao = photoPointDao;}

        @Override
        protected  Void doInBackground(PhotoPoints... photoPoints)
        {
            photoPointDao.addPhotoPoint(photoPoints[0]);
            return null;
        }
    }
    private static class InsertUserAsyncTask extends AsyncTask<User, Void ,Void>{
        private UserDao userDao;

        private InsertUserAsyncTask(UserDao userDao) {this.userDao = userDao;}

        @Override
        protected  Void doInBackground(User... users)
        {
            userDao.addUser(users[0]);
            return null;
        }
    }

}
