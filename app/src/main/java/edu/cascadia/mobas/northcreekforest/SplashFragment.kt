//Splash fragment that links to account creation
package edu.cascadia.mobas.northcreekforest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class SplashFragment : Fragment() {
    //Required for interface
    private var listener: edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_splash, container, false)

        //Set click listener for create profile
        rootView.findViewById<View>(R.id.accountForm).setOnClickListener { listener!!.displaySelectedScreen(R.id.nav_create) }

        return rootView
    }

    //Interface allowing use of DisplaySelectedScreen to nav away from fragment without nav drawer
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen?
        } catch (castException: ClassCastException) {
            // Activity is not implementing listener
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.title = "Welcome"
    }
}
