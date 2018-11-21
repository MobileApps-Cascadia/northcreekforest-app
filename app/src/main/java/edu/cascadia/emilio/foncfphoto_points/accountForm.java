package edu.cascadia.emilio.foncfphoto_points;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class accountForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_form);

        // Get the widget reference for XML layout
        EditText first = (EditText) findViewById(R.id.ac_first);
        EditText last = (EditText) findViewById(R.id.ac_last);
        EditText email = (EditText) findViewById(R.id.ac_email);
        EditText pin = (EditText) findViewById(R.id.ac_pin);

        first.setHintTextColor(Color.WHITE);
        last.setHintTextColor(Color.WHITE);
        email.setHintTextColor(Color.WHITE);
        pin.setHintTextColor(Color.WHITE);
    }
}
