package edu.cascadia.mobas.northcreekforest.models;


import android.provider.ContactsContract;

import org.w3c.dom.Text;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Entity(indices = {@Index("user_id")},
        tableName = "photoPoints_table",
        foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns =  "user_id"))
public class PhotoPoints{


    @PrimaryKey(autoGenerate = true)
    private int id;

    private int user_id;

    private String plant_name;

    private String date;

    private String comments;

    public PhotoPoints(String plant_name, String date, String comments) {
        this.plant_name = plant_name;
        this.date = date;
        this.comments = comments;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    public String getPlant_name() { return plant_name; }

    public void setPlant_name(String plant_name) { this.plant_name = plant_name; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }





}
