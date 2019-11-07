package edu.cascadia.mobas.northcreekforest.db


//import android.arch.persistence.db.SupportSQLiteDatabase;

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.cascadia.mobas.northcreekforest.models.PhotoPoints
import edu.cascadia.mobas.northcreekforest.models.Photo
import edu.cascadia.mobas.northcreekforest.models.User

@Database(entities = [PhotoPoints::class, Photo::class, User::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao
    abstract fun photoPointDao(): PhotoPointDao
    abstract fun userDao(): UserDao

    companion object {

        private var instance: AppDatabase? = null

        //Create singleton
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder<AppDatabase>(context.applicationContext,
                        AppDatabase::class.java!!, "app_database")
                        .fallbackToDestructiveMigration()
                        //.addCallback(roomCallback)
                        .build()
            }
            return instance as AppDatabase
        }
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
