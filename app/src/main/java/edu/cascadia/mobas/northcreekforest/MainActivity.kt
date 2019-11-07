package edu.cascadia.mobas.northcreekforest

import android.content.Intent
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.view.MenuItem

import com.google.zxing.integration.android.IntentIntegrator

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import edu.cascadia.mobas.northcreekforest.dummy.DummyContent

class MainActivity : AppCompatActivity(), DisplaySelectedScreen, //Interface
        NavigationView.OnNavigationItemSelectedListener, // Nav listener for drawer
        PlanetFragment.OnListFragmentInteractionListener { // ListFragment listener for plant list
    private var Mviewmodel: ActivityAccountViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        //Create nav drawer layout and add listener
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        //Create and set the nav view
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        displaySelectedScreen(R.id.nav_splash)

        //Check for ActivityCreation via Barcode Scanner
        val my_intent = intent
        val scannedPlant = my_intent.getStringExtra("ScannedPlant")

        initViewModel()

        if (scannedPlant != null) {
            //Activity created by BarcodeScanner
            val last4OfURL = Integer.parseInt(scannedPlant)
            plantSelectedHandler(last4OfURL)
        }

        //        getSupportFragmentManager()
        //            .beginTransaction()
        //            .add(R.id.content_frame, PlanetFragment.newInstance(1))
        //            .commit();
    }

    private fun initViewModel() {
        //Mviewmodel = ViewModelProviders.of(this)
        //                .get(ActivityAccountViewModel::class.java!!)

    }

    //Override Back Press to close drawer if open
    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun plantSelectedHandler(last4ofURL: Int) {

        // Get the plantID based on the last4ofURL
        val dummyItem: DummyContent.DummyItem
        var plantId: Int? = 0
        when (last4ofURL) {
            28092 -> plantId = 1 //Douglas Fir
            27710 -> plantId = 2 //Black Twinberry
            24480 -> plantId = 3 // Red-oiser Dogwood
            28062 -> plantId = 4 //Thimbleberry
            28067 -> plantId = 5 //Sitka Spruce
            28071 -> plantId = 6 //Slough Sedge
            28070 -> plantId = 7 //Clustered Rose
            28703 -> plantId = 8 //Western Redcedar
            27711 -> plantId = 9 //Red Flowering Currant
            28088 -> plantId = 10 //Small-fruited Bulrush
            28094 -> plantId = 11 //Low Oregon Grape
            28064 -> plantId = 12 //Tall Oregon Grape
            28063 -> plantId = 13 //Pacific Ninebark
            28075 -> plantId = 14 //Cascara
            28061 -> plantId = 15 //Mock Orange
            28097 -> plantId = 16 //Pacific Willow
            28086 -> plantId = 17 //Black Cottonwood
            28066 -> plantId = 18 //Paper Birch
            28217 -> plantId = 19 //Grand Fir
            28704 -> plantId = 20 //Red Alder
            28098 -> plantId = 21 //Red Elderberry
        }

        if (plantId != 0) {
            //Create Fragment with intent
            val ft = supportFragmentManager.beginTransaction()
            val bundle = Bundle()
            val myMessage = plantId!!
            bundle.putInt("plantId", myMessage)
            val plantInfo = PlanetFragment()
            plantInfo.arguments = bundle
            ft.replace(R.id.content_frame, plantInfo)
            ft.commit()
        }
    }

    //Handle list fragment events
    override fun onListFragmentInteraction(s: DummyContent.DummyItem) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_frame, PlantInfo.newInstance(s.content, s.details, s.info))
                .addToBackStack(BACK_STACK_ROOT_TAG)
                .commit()
    }

    //Handle navigation selection events
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.isChecked = true
        displaySelectedScreen(menuItem.itemId)
        return true
    }

    //Interface Method
    //Sets creates fragment for selected nav item
    override fun displaySelectedScreen(itemId: Int) {

        //creating fragment object
        var fragment: Fragment? = null

        //initializing the fragment object which is selected
        when (itemId) {
            R.id.nav_home -> fragment = Landing()
            R.id.nav_scan -> startActivity(Intent(this@MainActivity, BarcodeScanner::class.java))
            R.id.nav_plants -> fragment = PlanetFragment()
            R.id.nav_about -> fragment = About()
            R.id.nav_contact -> fragment = ContactActivity()
            R.id.nav_splash -> fragment = SplashFragment()
            R.id.nav_create -> fragment = AccountForm()
        }

        //Clear backstack   `
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack(BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        //replacing the fragment

        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_frame, fragment)
            ft.commit()
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)


    }

    companion object {

        private val BACK_STACK_ROOT_TAG = "root_fragment"
    }
}
