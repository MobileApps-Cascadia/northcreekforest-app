//This fragment displays the account creation form
package edu.cascadia.mobas.northcreekforest;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import edu.cascadia.mobas.northcreekforest.models.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class accountForm extends Fragment {
    //Required for interface
    private edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen listener;

    private activity_account_formViewModel AddUsers;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_account_form, container, false);

        AddUsers = ViewModelProviders.of(this).get(activity_account_formViewModel.class);
        // create the instance of the view model on load.
        // Get the widget reference for XML layout
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        EditText first = (EditText) rootView.findViewById(R.id.ac_first);
        EditText last = (EditText) rootView.findViewById(R.id.ac_last);
        EditText email = (EditText) rootView.findViewById(R.id.ac_email);
        EditText pin = (EditText) rootView.findViewById(R.id.ac_pin);
        Button button = (Button) rootView.findViewById(R.id.profile_button);


        //On click for submit button takes you to home screen
        rootView.findViewById(R.id.profile_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (first.getText() == null
                            || last.getText() == null
                            || email.getText() == null
                            || pin.getText() == null) {

                       // Toast.makeText(getActivity(), "Message", Toast.LENGTH_SHORT).show();
                        listener.displaySelectedScreen(R.id.nav_create);
                    }
                    else {


                        AddUsers.addUser(new User(
                                first.getText().toString(),
                                last.getText().toString(),
                                Integer.parseInt(pin.getText().toString())
                        ));

                    }


                listener.displaySelectedScreen(R.id.nav_home);
            }
        });


//
//        setSupportActionBar(toolbar);
//        //getSupportActionBar().setTitle("");
//
//        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_launcher_xhdpi));
//        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // set hint text color to white
        first.setHintTextColor(Color.WHITE);
        last.setHintTextColor(Color.WHITE);
        email.setHintTextColor(Color.WHITE);
        pin.setHintTextColor(Color.WHITE);
        button.setTextColor(Color.WHITE);


        return rootView;
    }

    //Interface allowing use of DisplaySelectedScreen to nav away from fragment WITHOUT nav drawer
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen) context;
        }catch (ClassCastException castException){
            // Activity is not implementing listener
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Create Account");
    }

}
