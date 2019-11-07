package edu.cascadia.emilio.foncfphoto_points

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {


    private var button: Button? = null

    @Override
    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.accountForm) as Button
        button!!.setOnClickListener(object : View.OnClickListener() {
            @Override
            fun onClick(v: View) {
                accountForm()
            }
        })

    }

    fun accountForm() {
        val intent = Intent(this, accountForm::class.java)
        startActivity(intent)

    }
}
