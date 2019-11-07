package edu.cascadia.mobas.northcreekforest.db


import androidx.lifecycle.LiveData

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import edu.cascadia.mobas.northcreekforest.models.Photo


@Dao
interface PhotoDao {

    @get:Query("SELECT * FROM photos_table ORDER BY id DESC")
    val allPhotos: LiveData<List<Photo>>

    //create and update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPhoto(photo: Photo)

    @Update
    fun updatePhoto(photo: Photo)

    @Delete
    fun deletePhoto(photo: Photo)

    @Query("DELETE FROM photos_table")
    fun deleteAllPhotos()

}
