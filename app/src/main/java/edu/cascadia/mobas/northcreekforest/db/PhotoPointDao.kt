package edu.cascadia.mobas.northcreekforest.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


import edu.cascadia.mobas.northcreekforest.models.PhotoPoints

@Dao
interface PhotoPointDao {

    @get:Query("SELECT * FROM photoPoints_table ORDER BY id DESC")
    val allPhotoPoints: LiveData<List<PhotoPoints>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPhotoPoint(photoPoints: PhotoPoints)

    @Update
    fun updatePhotoPoint(photoPoints: PhotoPoints)

    @Delete
    fun deletePhoto(photoPoints: PhotoPoints)

    @Query("DELETE FROM photoPoints_table")
    fun deleteAllPhotoPoints()
}
