package edu.cascadia.mobas.northcreekforest.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


import edu.cascadia.mobas.northcreekforest.models.User

@Dao
interface UserDao {

    //Read

    @get:Query("SELECT * FROM user_table ORDER BY id DESC")
    val allUsers: LiveData<List<User>>

    //count
    @get:Query("select COUNT(*) from user_table")
    val count: Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(users: List<User>)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deletePhoto(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAllUsers()


    @Query("select * from user_table where id = :id")
    fun getUser(id: Int): User

}
