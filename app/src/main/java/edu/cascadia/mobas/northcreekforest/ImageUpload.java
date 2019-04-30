package edu.cascadia.mobas.northcreekforest;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cascadia.mobas.northcreekforest.dummy.DummyContent;
import edu.cascadia.mobas.northcreekforest.models.Photo;

import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageUpload extends Fragment{

    private static final int PICKFILE_RESULT_CODE = 1;

    public UploadViewModel addPhoto;
    private int mColumnCount = 1;
    private int mPlantId = 0;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_PLANT_ID = "plantId";
    private PlanetFragment.OnListFragmentInteractionListener mListener;
    private edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            mPlantId = getArguments().getInt(ARG_PLANT_ID);
        }
    }


    public ImageUpload() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_image_upload, container, false);


        EditText weather = (EditText) view.findViewById(R.id.InfoBoxOne);
        EditText Filler = (EditText) view.findViewById(R.id.InfoBoxTwo);
        EditText info = (EditText)view.findViewById(R.id.InfoBoxThree);
        Button button = (Button) view.findViewById(R.id.imgupload);



        button.setOnClickListener(v -> {

            addPhoto.addPhoto(new Photo(weather.toString()));

            listener.displaySelectedScreen(R.id.nav_scan);


        });

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyPlantsRecyclerViewAdapter(DummyContent.ITEMS, mListener, mPlantId));
        }

       return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PlanetFragment.OnListFragmentInteractionListener) {
            mListener = (PlanetFragment.OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
