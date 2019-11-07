package edu.cascadia.mobas.northcreekforest


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.cascadia.mobas.northcreekforest.dummy.DummyContent
import edu.cascadia.mobas.northcreekforest.models.Photo

import android.text.style.UpdateLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast


class ImageUpload : Fragment() {

    var addPhoto: UploadViewModel? = null
    private var mColumnCount = 1
    private var mPlantId = 0
    private var mListener: PlanetFragment.OnListFragmentInteractionListener? = null
    private val listener: edu.cascadia.mobas.northcreekforest.DisplaySelectedScreen? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments!!.getInt(ARG_COLUMN_COUNT)
            mPlantId = arguments!!.getInt(ARG_PLANT_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_image_upload, container, false)


        val weather = view.findViewById<View>(R.id.InfoBoxOne) as EditText
        val Filler = view.findViewById<View>(R.id.InfoBoxTwo) as EditText
        val info = view.findViewById<View>(R.id.InfoBoxThree) as EditText
        val button = view.findViewById<View>(R.id.imgupload) as Button



        button.setOnClickListener { v ->
            val Value = Photo("testingValue")
            Value.point_id = 9

            // addPhoto.addPhoto(Value);

            if (weather == null
                    || Filler == null
                    || info == null) {

            } else {
                fragmentManager!!.beginTransaction()
                        .replace(R.id.content_frame, SplashFragment())
                        .addToBackStack(null).commit()

            }
        }

        if (view is RecyclerView) {
            val context = view.getContext()
            if (mColumnCount <= 1) {
                view.layoutManager = LinearLayoutManager(context)
            } else {
                view.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            view.adapter = MyPlantsRecyclerViewAdapter(DummyContent.ITEMS, mListener, mPlantId)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is PlanetFragment.OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    companion object {

        private val PICKFILE_RESULT_CODE = 1
        private val ARG_COLUMN_COUNT = "column-count"
        private val ARG_PLANT_ID = "plantId"
    }


}// Required empty public constructor
