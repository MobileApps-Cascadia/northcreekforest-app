//Default home page once account is created
package edu.cascadia.mobas.northcreekforest;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Landing extends Fragment {
    private edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen listener;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_landing, container, false);

        //Listener for scan button, takes you to scan fragment
        rootView.findViewById(R.id.btnScan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.displaySelectedScreen(R.id.nav_scan);
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
        getActivity().setTitle("Home");
    }
}
