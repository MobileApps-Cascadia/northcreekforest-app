package edu.cascadia.emilio.foncfphoto_points

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toolbar

class accountForm : AppCompatActivity() {

    @Override
    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_form)
        val myToolbar = findViewById(R.id.my_toolbar) as Toolbar

        // Get the widget reference for XML layout
        val first = findViewById(R.id.ac_first) as EditText
        val last = findViewById(R.id.ac_last) as EditText
        val email = findViewById(R.id.ac_email) as EditText
        val pin = findViewById(R.id.ac_pin) as EditText

        first.setHintTextColor(Color.WHITE)
        last.setHintTextColor(Color.WHITE)
        email.setHintTextColor(Color.WHITE)
        pin.setHintTextColor(Color.WHITE)
    }
}
