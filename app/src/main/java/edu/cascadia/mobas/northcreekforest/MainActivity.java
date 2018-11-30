package edu.cascadia.mobas.northcreekforest;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import edu.cascadia.mobas.northcreekforest.dummy.DummyContent;

public class MainActivity extends FragmentActivity implements PlanetFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.PlantFragmentContainer, PlanetFragment.newInstance(1))
                .commit();
    }

    public void onListFragmentInteraction(DummyContent.DummyItem s){
        getSupportFragmentManager()
                .beginTransaction()
                //Replace PlanetFragment with the new fragment you create. Figure out if a blank fragment would work.
                .replace(R.id.PlantFragmentContainer, PlantInfo.newInstance(s.content, s.details, s.info))
                .addToBackStack("back")
                .commit();
    }
}
