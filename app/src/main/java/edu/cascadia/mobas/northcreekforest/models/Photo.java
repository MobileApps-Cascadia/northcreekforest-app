package edu.cascadia.mobas.northcreekforest.models;



import java.sql.Blob;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "photos_table",
        foreignKeys = @ForeignKey(entity = PhotoPoints.class,
        parentColumns = "id",
        childColumns = "point_id"))
public class Photo{

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int point_id;

    private Blob photos;

    public Photo(Blob photos) {
        this.photos = photos;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlant_id() {
        return point_id;
    }

    public void setPlant_id(int point_id) { this.point_id = point_id; }

    public Blob getPhotos() {
        return photos;
    }

    public void setPhotos(Blob photos) {
        this.photos = photos;
    }
}
