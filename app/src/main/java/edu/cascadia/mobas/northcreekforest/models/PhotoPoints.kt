package edu.cascadia.mobas.northcreekforest.models


import android.provider.ContactsContract

import org.w3c.dom.Text

import java.util.Date

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Entity(indices = [Index("user_id")], tableName = "photoPoints_table", foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])])
class PhotoPoints(var plant_name: String?, var date: String?, var comments: String?) {


    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var user_id: Int = 0


}
