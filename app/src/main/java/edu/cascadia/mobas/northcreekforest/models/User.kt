package edu.cascadia.mobas.northcreekforest.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User(var user_Name: String?, var email: String?, var age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}
