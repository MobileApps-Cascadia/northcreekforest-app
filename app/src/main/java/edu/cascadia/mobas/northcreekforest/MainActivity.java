package edu.cascadia.mobas.northcreekforest;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;

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

    //Handle navigation selection events
    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem menuItem) {
        menuItem.setChecked(true);
        displaySelectedScreen(menuItem.getItemId());
        return true;
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

    //Interface Method
    //Sets creates fragment for selected nav item
    @Override
    public void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:
                fragment = new Landing();
                break;
            case R.id.nav_scan:
                //fragment = new Scan();
                startActivity(new Intent(MainActivity.this, BarcodeScanner.class));
                break;
            case R.id.nav_plants:
                fragment = new PlanetFragment();
                break;
            case R.id.nav_about:
                fragment = new About();
                break;
            case R.id.nav_contact:
                fragment = new ContactActivity();
                break;
            case R.id.nav_splash:
                fragment = new SplashFragment();
                break;
            case R.id.nav_create:
                fragment = new accountForm();

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
