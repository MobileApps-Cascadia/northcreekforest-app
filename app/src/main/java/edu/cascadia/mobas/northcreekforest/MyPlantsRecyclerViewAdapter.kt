//Controls plant view
package edu.cascadia.mobas.northcreekforest

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import edu.cascadia.mobas.northcreekforest.dummy.DummyContent.DummyItem


class MyPlantsRecyclerViewAdapter(private val mValues: List<DummyItem>, private val mListener: PlanetFragment.OnListFragmentInteractionListener?, private val mPlantID: Int) : RecyclerView.Adapter<MyPlantsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_plants, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var position = position
        if (mPlantID > 0) {
            //Force the scanned plant to show up in every slot on the viewholder, this allows auto click later
            position = mPlantID!! - 1
        }

        holder.mItem = mValues[position]
        holder.mIdView.text = mValues[position].id
        holder.mContentView.text = mValues[position].content

        val listener = View.OnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem as DummyItem)
        }
        holder.mView.setOnClickListener(listener)

        if (mPlantID > 0) {
            //PlantID was passed so force a click
            listener.onClick(holder.itemView)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView
        val mContentView: TextView
        var mItem: DummyItem? = null

        init {
            mIdView = mView.findViewById<View>(R.id.item_number) as TextView
            mContentView = mView.findViewById<View>(R.id.content) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
