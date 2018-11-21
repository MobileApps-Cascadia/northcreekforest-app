package edu.cascadia.emilio.foncfphoto_points;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Activity about = new About();

        Intent intent = new Intent(this, About.class);

        startActivity(intent);


    }
}
