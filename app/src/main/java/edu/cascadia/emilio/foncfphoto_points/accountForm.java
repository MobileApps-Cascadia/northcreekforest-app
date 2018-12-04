package edu.cascadia.emilio.foncfphoto_points;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;


public class accountForm extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_form);

        // Get the widget reference for XML layout
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        EditText first = (EditText) findViewById(R.id.ac_first);
        EditText last = (EditText) findViewById(R.id.ac_last);
        EditText email = (EditText) findViewById(R.id.ac_email);
        EditText pin = (EditText) findViewById(R.id.ac_pin);
        Button button = (Button) findViewById(R.id.profile_button);

        setSupportActionBar(my_toolbar);
        //getSupportActionBar().setTitle("");

        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_launcher_xhdpi));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        first.setHintTextColor(Color.WHITE);
        last.setHintTextColor(Color.WHITE);
        email.setHintTextColor(Color.WHITE);
        pin.setHintTextColor(Color.WHITE);
        button.setTextColor(Color.WHITE);
    }
}
