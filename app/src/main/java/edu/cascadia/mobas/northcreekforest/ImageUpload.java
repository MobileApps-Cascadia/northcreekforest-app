package edu.cascadia.mobas.northcreekforest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageUpload extends Fragment {


    ImageView StreamImage;

    private static final int PICKFILE_RESULT_CODE = 1;

    public ImageUpload() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_image_upload, container, false);

       return view;
    }

}
