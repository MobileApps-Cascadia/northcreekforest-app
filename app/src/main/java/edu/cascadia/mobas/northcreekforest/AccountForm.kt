//This fragment displays the account creation form
package edu.cascadia.mobas.northcreekforest

import android.content.Context
import android.graphics.Color
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import edu.cascadia.mobas.northcreekforest.models.User

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class AccountForm : Fragment() {
    //Required for interface
    private var listener: edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen? = null

    private var AddUsers: ActivityAccountViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.activity_account_form, container, false)

        AddUsers = ViewModelProviders.of(this).get(ActivityAccountViewModel::class.java)
        // create the instance of the view model on load.
        // Get the widget reference for XML layout
        val toolbar = rootView.findViewById<View>(R.id.toolbar) as Toolbar
        val first = rootView.findViewById<View>(R.id.ac_first) as EditText
        val last = rootView.findViewById<View>(R.id.ac_last) as EditText
        val email = rootView.findViewById<View>(R.id.ac_email) as EditText
        val pin = rootView.findViewById<View>(R.id.ac_pin) as EditText
        val button = rootView.findViewById<View>(R.id.profile_button) as Button


        //On click for submit button takes you to home screen
        rootView.findViewById<View>(R.id.profile_button).setOnClickListener {
            if (first.text == null
                    || last.text == null
                    || email.text == null
                    || pin.text == null) {

                // Toast.makeText(getActivity(), "Message", Toast.LENGTH_SHORT).show();
                listener!!.displaySelectedScreen(R.id.nav_create)
            } else {


                AddUsers!!.addUser(User(
                        first.text.toString(),
                        last.text.toString(),
                        Integer.parseInt(pin.text.toString())
                ))

            }


            listener!!.displaySelectedScreen(R.id.nav_home)
        }


        //
        //        setSupportActionBar(toolbar);
        //        //getSupportActionBar().setTitle("");
        //
        //        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_launcher_xhdpi));
        //        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // set hint text color to white
        first.setHintTextColor(Color.WHITE)
        last.setHintTextColor(Color.WHITE)
        email.setHintTextColor(Color.WHITE)
        pin.setHintTextColor(Color.WHITE)
        button.setTextColor(Color.WHITE)


        return rootView
    }

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
        activity!!.title = "Create Account"
    }

}
