package edu.cascadia.mobas.northcreekforest.db;


//import android.arch.persistence.db.SupportSQLiteDatabase;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cascadia.mobas.northcreekforest.models.PhotoPoints;
import edu.cascadia.mobas.northcreekforest.models.Photo;
import edu.cascadia.mobas.northcreekforest.models.User;

@Database(entities = {PhotoPoints.class, Photo.class, User.class}, version =3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract PhotoDao photoDao();
    public abstract PhotoPointDao photoPointDao();
    public abstract UserDao userDao();

    //Create singleton
    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    //.addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    //private static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
    //    @Override
    //    public void onCreate(@NonNull SupportSQLiteDatabase db){
    //        super.onCreate(db);
    //        new PopulateDbAsyncTask(instance).execute();
    //}
    //};

    //private static class PopulateDbAsyncTask extends AsyncTask


}
