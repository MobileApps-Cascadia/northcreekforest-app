package edu.cascadia.mobas.northcreekforest.models;



import java.sql.Blob;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index("point_id")},
        tableName = "photos_table",
        foreignKeys = @ForeignKey(entity = PhotoPoints.class,
        parentColumns = "id",
        childColumns = "point_id"))
public class Photo{

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int point_id;

    private String photos;

    public Photo(String photos) {
        this.photos = photos;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint_id() {
        return point_id;
    }

    public void setPoint_id(int point_id) { this.point_id = point_id; }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
