package edu.cascadia.mobas.northcreekforest;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.google.zxing.integration.android.IntentIntegrator;
import java.sql.Clob;
import edu.cascadia.mobas.northcreekforest.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements
        DisplaySelectedScreen, //Interface
        NavigationView.OnNavigationItemSelectedListener, // Nav listener for drawer
        PlanetFragment.OnListFragmentInteractionListener{ // ListFragment listener for plant list

    private static final String BACK_STACK_ROOT_TAG = "root_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Create nav drawer layout and add listener
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Create and set the nav view
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_splash);

        //Check for ActivityCreation via Barcode Scanner
        Intent my_intent = getIntent();
        String scannedPlant = my_intent.getStringExtra("ScannedPlant");


        if(scannedPlant != null) {
            //Activity created by BarcodeScanner
            int last4OfURL = Integer.parseInt(scannedPlant);
            plantSelectedHandler(last4OfURL);
        }

//        getSupportFragmentManager()
//            .beginTransaction()
//            .add(R.id.content_frame, PlanetFragment.newInstance(1))
//            .commit();
    }

    //Override Back Press to close drawer if open
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void plantSelectedHandler(int last4ofURL) {

        // Get the plantID based on the last4ofURL
        DummyContent.DummyItem dummyItem;
        Integer plantId = 0;
        switch (last4ofURL) {
            case 28092: plantId = 1; //Douglas Fir
                break;
            case 27710: plantId = 2; //Black Twinberry
                break;
            case 24480: plantId = 3; // Red-oiser Dogwood
                break;
            case 28062: plantId = 4; //Thimbleberry
                break;
            case 28067: plantId = 5; //Sitka Spruce
                break;
            case 28071: plantId = 6; //Slough Sedge
                break;
            case 28070: plantId = 7; //Clustered Rose
                break;
            case 28703: plantId = 8; //Western Redcedar
                break;
            case 27711: plantId = 9; //Red Flowering Currant
                break;
            case 28088: plantId = 10; //Small-fruited Bulrush
                break;
            case 28094: plantId = 11; //Low Oregon Grape
                break;
            case 28064: plantId = 12; //Tall Oregon Grape
                break;
            case 28063: plantId = 13; //Pacific Ninebark
                break;
            case 28075: plantId = 14; //Cascara
                break;
            case 28061: plantId = 15; //Mock Orange
                break;
            case 28097: plantId = 16; //Pacific Willow
                break;
            case 28086: plantId = 17; //Black Cottonwood
                break;
            case 28066: plantId = 18; //Paper Birch
                break;
            case 28217: plantId = 19; //Grand Fir
                break;
            case 28704: plantId = 20; //Red Alder
                break;
            case 28098: plantId = 21; //Red Elderberry
                break;

        }

        if (plantId != 0) {
            //Create Fragment with intent
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            int myMessage = plantId;
            bundle.putInt("plantId", myMessage);
            PlanetFragment plantInfo = new PlanetFragment();
            plantInfo.setArguments(bundle);
            ft.replace(R.id.content_frame, plantInfo);
            ft.commit();
        }
    }

    //Handle list fragment events
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem s) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, PlantInfo.newInstance(s.content, s.details, s.info))
                .addToBackStack(BACK_STACK_ROOT_TAG)
                .commit();
        }

    //Handle navigation selection events
    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem menuItem) {
        menuItem.setChecked(true);
        displaySelectedScreen(menuItem.getItemId());
        return true;
    }

    //Interface Method
    //Sets creates fragment for selected nav item
    @Override
    public void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home: fragment = new Landing(); break;
            case R.id.nav_scan: startActivity(new Intent(MainActivity.this, BarcodeScanner.class));break;
            case R.id.nav_plants: fragment = new PlanetFragment();break;
            case R.id.nav_about: fragment = new About(); break;
            case R.id.nav_contact: fragment = new ContactActivity(); break;
            case R.id.nav_splash: fragment = new SplashFragment(); break;
            case R.id.nav_create: fragment = new accountForm();
        }

        //Clear backstack   `
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


    }
}
