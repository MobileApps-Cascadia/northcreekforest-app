package edu.cascadia.mobas.northcreekforest;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import android.media.Image;
import android.os.AsyncTask;

import java.sql.Blob;
import androidx.annotation.NonNull;
import edu.cascadia.mobas.northcreekforest.db.AppDatabase;
import edu.cascadia.mobas.northcreekforest.models.Photo;

public class UploadViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AppRepository apprepo;

    public UploadViewModel(@NonNull Application application) {
        super(application);



        appDatabase = AppDatabase.getInstance(getApplication());

    }



    public void addPhoto(Photo photos){

        new addAsyncTask(appDatabase).execute(photos);


    }



    private static class addAsyncTask extends AsyncTask< Photo, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase){
            db = appDatabase;
        }


        @Override
        protected Void doInBackground(Photo... photos) {
            db.photoDao().addPhoto(photos[0]);
            return null;
        }

    }
}