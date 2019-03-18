package edu.cascadia.mobas.northcreekforest.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


import edu.cascadia.mobas.northcreekforest.models.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAll(List<User> users);

    @Update
    void updateUser(User user);

    @Delete
    void deletePhoto(User user);

    @Query("DELETE FROM user_table")
    void deleteAllUsers();

    //Read

    @Query("SELECT * FROM user_table ORDER BY id DESC")
    LiveData<List<User>> getAllUsers();


    @Query("select * from user_table where id = :id")
    User getUser(int id);

    //count
    @Query("select COUNT(*) from user_table")
    int getCount();

}
