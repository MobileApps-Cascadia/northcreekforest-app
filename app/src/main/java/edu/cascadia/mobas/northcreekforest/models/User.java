package edu.cascadia.mobas.northcreekforest.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String user_Name;

    private String email;

    private int age;

    public User(String user_Name, String email, int age) {
        this.user_Name = user_Name;
        this.email = email;
        this.age = age;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUser_Name() { return user_Name; }

    public void setUser_Name(String user_Name) { this.user_Name = user_Name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }



}
