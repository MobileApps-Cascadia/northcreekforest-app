//Contact Fragment
package edu.cascadia.mobas.northcreekforest;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ContactActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_contact, container, false);

        //Listener for submit
        rootView.findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Get subject and message
                String sub = ((EditText)rootView.findViewById(R.id.txtSubject)).getText().toString();
                String mess = ((EditText)rootView.findViewById(R.id.txtMessage)).getText().toString();

                //Open email prompt with intent
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{"testingfncf@gmail.com"});
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
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Contact");
    }
}
