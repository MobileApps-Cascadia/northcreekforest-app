package edu.cascadia.mobas.northcreekforest.models


import java.sql.Blob

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("point_id")], tableName = "photos_table", foreignKeys = [ForeignKey(entity = PhotoPoints::class, parentColumns = ["id"], childColumns = ["point_id"])])
class Photo(var photos: String?) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var point_id: Int = 0
}
