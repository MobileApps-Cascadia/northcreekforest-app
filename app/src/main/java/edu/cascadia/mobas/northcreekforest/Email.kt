package edu.cascadia.mobas.northcreekforest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Email : AppCompatActivity(), View.OnClickListener {

    lateinit var inSubject: EditText
    lateinit var inBody: EditText
    lateinit var txtEmailAddress: TextView
    lateinit var btnSendEmail: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        initViews()
    }

    private fun initViews() {
        inSubject = findViewById(R.id.inSubject)
        inBody = findViewById(R.id.inBody)
        txtEmailAddress = findViewById(R.id.txtEmailAddress)
        btnSendEmail = findViewById(R.id.btnSendEmail)


        if (intent.getStringExtra("email_address") != null) {
            txtEmailAddress.text = "Recipient : " + intent.getStringExtra("email_address")
        }

        btnSendEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(txtEmailAddress.text.toString()))
            intent.putExtra(Intent.EXTRA_SUBJECT, inSubject.text.toString().trim { it <= ' ' })
            intent.putExtra(Intent.EXTRA_TEXT, inBody.text.toString().trim { it <= ' ' })

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }

    override fun onClick(v: View) {

    }
}
