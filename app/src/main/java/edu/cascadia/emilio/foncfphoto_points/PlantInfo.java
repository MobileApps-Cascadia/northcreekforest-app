package edu.cascadia.emilio.foncfphoto_points;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlantInfo extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";
    //private static final String ARG_PARAM2 = "content";

    private String mId;
    //private String mContent;

    //private OnFragmentInteractionListener mListener;

    public PlantInfo() {
        // Required empty public constructor
    }

    public static PlantInfo newInstance(String id) {
        PlantInfo fragment = new PlantInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, id);
        //args.putString(ARG_PARAM2, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mId = getArguments().getString(ARG_PARAM1);
            //mContent = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_plant_info, container, false);
        TextView myTextView = myView.findViewById(R.id.Plant);
        myTextView.setText(mId);
        return myView;

//        TextView myPlantInfoView = myView.findViewById(R.id.PlantName);
//        myTextView.setText(mContent);
    }

//    public void onButtonPressed(Fragment f) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(f);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Fragment f);
//    }
}
