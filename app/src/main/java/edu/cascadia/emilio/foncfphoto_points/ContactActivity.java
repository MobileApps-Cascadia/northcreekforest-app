package edu.cascadia.emilio.foncfphoto_points;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        (findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sub = ((EditText)findViewById(R.id.txtSubject)).getText().toString();
                String mess = ((EditText)findViewById(R.id.txtMessage)).getText().toString();


                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{"aaronakohler@gmail.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                mail.putExtra(Intent.EXTRA_TEXT, mess);
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Send email via:"));


                // Remove block comment for dialog confirmation
                /*AlertDialog.Builder builder1 = new AlertDialog.Builder(ContactActivity.this);
                builder1.setMessage("Message Sent");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                builder1.show();*/
            }
        });
    }

}
