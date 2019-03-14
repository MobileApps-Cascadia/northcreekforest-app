//This fragment displays the account creation form
package edu.cascadia.mobas.northcreekforest;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class accountForm extends Fragment {
    //Required for interface
    private edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen listener;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_account_form, container, false);

        //On click for submit button takes you to home screen
        rootView.findViewById(R.id.profile_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.displaySelectedScreen(R.id.nav_home);
            }
        });

        // Get the widget reference for XML layout
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        EditText first = (EditText) rootView.findViewById(R.id.ac_first);
        EditText last = (EditText) rootView.findViewById(R.id.ac_last);
        EditText email = (EditText) rootView.findViewById(R.id.ac_email);
        EditText pin = (EditText) rootView.findViewById(R.id.ac_pin);
        Button button = (Button) rootView.findViewById(R.id.profile_button);
//
//        setSupportActionBar(toolbar);
//        //getSupportActionBar().setTitle("");
//
//        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_launcher_xhdpi));
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

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
