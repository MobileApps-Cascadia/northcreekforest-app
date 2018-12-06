//Splash fragment that links to account creation
package edu.cascadia.mobas.northcreekforest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SplashFragment extends Fragment {
    //Required for interface
    private edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen listener;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_splash, container, false);

        //Set click listener for create profile
        rootView.findViewById(R.id.accountForm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.displaySelectedScreen(R.id.nav_create);
            }
        });

        return rootView;
    }

    //Interface allowing use of DisplaySelectedScreen to nav away from fragment without nav drawer
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
        getActivity().setTitle("Welcome");
    }
}
