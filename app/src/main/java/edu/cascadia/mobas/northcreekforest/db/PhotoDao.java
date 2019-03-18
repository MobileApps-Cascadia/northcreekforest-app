package edu.cascadia.mobas.northcreekforest.db;


import android.arch.lifecycle.LiveData;

import android.provider.ContactsContract;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cascadia.mobas.northcreekforest.models.Photo;


@Dao
public interface PhotoDao {

    //create and update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPhoto(Photo photo);

    @Update
    void updatePhoto(Photo photo);

    @Delete
    void deletePhoto(Photo photo);

    @Query("DELETE FROM photos_table")
    void deleteAllPhotos();

    @Query("SELECT * FROM photos_table ORDER BY id DESC")
    LiveData<List<Photo>> getAllPhotos();

}
