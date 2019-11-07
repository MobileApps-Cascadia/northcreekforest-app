package edu.cascadia.mobas.northcreekforest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class PlantInfo : Fragment(), View.OnClickListener {

    private var mContent: String? = null
    private var mDetails: String? = null
    private var mInfo: String? = null
    private var submitButton: Button? = null

    private var uploadViewModel: UploadViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mContent = arguments!!.getString(ARG_PARAM1)
            mDetails = arguments!!.getString(ARG_PARAM2)
            mInfo = arguments!!.getString(ARG_PARAM3)

            uploadViewModel = ViewModelProviders.of(this).get(UploadViewModel::class.java!!)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_plant_info, container, false)

        val myTextView = myView.findViewById<TextView>(R.id.PlantName)
        val mySecondTextView = myView.findViewById<TextView>(R.id.PlantContent)
        val myInfoView = myView.findViewById<TextView>(R.id.PlantInfo)

        submitButton = myView.findViewById(R.id.submit)
        submitButton!!.setOnClickListener(this)

        myTextView.text = mContent
        mySecondTextView.text = mDetails
        myInfoView.text = mInfo

        return myView
    }

    override fun onClick(v: View) {

        fragmentManager!!.beginTransaction()
                .replace(R.id.content_frame, ImageUpload())
                .addToBackStack(null).commit()
    }

    override fun onDetach() {

        super.onDetach()
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "content"
        private val ARG_PARAM2 = "details"
        private val ARG_PARAM3 = "info"

        fun newInstance(content: String, details: String, info: String): PlantInfo {
            val fragment = PlantInfo()
            val args = Bundle()
            args.putString(ARG_PARAM1, content)
            args.putString(ARG_PARAM2, details)
            args.putString(ARG_PARAM3, info)
            fragment.arguments = args
            return fragment
        }
    }

    //    public interface OnFragmentInteractionListener {
    //        // TODO: Update argument type and name
    //        void onFragmentInteraction(Fragment f);
    //    }
}// Required empty public constructor