package edu.cascadia.mobas.northcreekforest.db;


import android.arch.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


import edu.cascadia.mobas.northcreekforest.models.PhotoPoints;

@Dao
public interface PhotoPointDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPhotoPoint(PhotoPoints photoPoints);

    @Update
    void updatePhotoPoint(PhotoPoints photoPoints);

    @Delete
    void deletePhoto(PhotoPoints photoPoints);

    @Query("DELETE FROM photoPoints_table")
    void deleteAllPhotoPoints();

    @Query("SELECT * FROM photoPoints_table ORDER BY id DESC")
    LiveData<List<PhotoPoints>> getAllPhotoPoints();
}
