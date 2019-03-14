package edu.cascadia.mobas.northcreekforest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PlantInfo extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "content";
    private static final String ARG_PARAM2 = "details";
    private static final String ARG_PARAM3 = "info";

    private String mContent;
    private String mDetails;
    private String mInfo;
    private Button submitButton;

    public PlantInfo() {
        // Required empty public constructor
    }

    public static PlantInfo newInstance(String content, String details, String info) {
        PlantInfo fragment = new PlantInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, content);
        args.putString(ARG_PARAM2, details);
        args.putString(ARG_PARAM3, info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContent = getArguments().getString(ARG_PARAM1);
            mDetails = getArguments().getString(ARG_PARAM2);
            mInfo = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_plant_info, container, false);
        TextView myTextView = myView.findViewById(R.id.PlantName);
        TextView mySecondTextView = myView.findViewById(R.id.PlantContent);
        TextView myInfoView = myView.findViewById(R.id.PlantInfo);

        submitButton = myView.findViewById(R.id.submit);
        submitButton.setOnClickListener(this);

        myTextView.setText(mContent);
        mySecondTextView.setText(mDetails);
        myInfoView.setText(mInfo);

        return myView;
    }

    @Override
    public void onClick(View v) {

        getFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new ImageUpload())
                .addToBackStack(null).commit();
    }

    @Override
    public void onDetach() {

        super.onDetach();
    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Fragment f);
//    }
}