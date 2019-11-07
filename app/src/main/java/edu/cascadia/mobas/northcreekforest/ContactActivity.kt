//Contact Fragment
package edu.cascadia.mobas.northcreekforest

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class ContactActivity : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.activity_contact, container, false)

        //Listener for submit
        rootView.findViewById<View>(R.id.btnOK).setOnClickListener {
            //Get subject and message
            val sub = (rootView.findViewById<View>(R.id.txtSubject) as EditText).text.toString()
            val mess = (rootView.findViewById<View>(R.id.txtMessage) as EditText).text.toString()

            //Open email prompt with intent
            val mail = Intent(Intent.ACTION_SEND)
            mail.putExtra(Intent.EXTRA_EMAIL, arrayOf("testingfncf@gmail.com"))
            mail.putExtra(Intent.EXTRA_SUBJECT, sub)
            mail.putExtra(Intent.EXTRA_TEXT, mess)
            mail.type = "message/rfc822"
            startActivity(Intent.createChooser(mail, "Send email via:"))


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
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.title = "Contact"
    }
}
