//Controls plant view
package edu.cascadia.mobas.northcreekforest;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.cascadia.mobas.northcreekforest.dummy.DummyContent.DummyItem;

import java.util.List;


public class MyPlantsRecyclerViewAdapter extends RecyclerView.Adapter<MyPlantsRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final PlanetFragment.OnListFragmentInteractionListener mListener;
    private final Integer mPlantID;

    public MyPlantsRecyclerViewAdapter(List<DummyItem> items, PlanetFragment.OnListFragmentInteractionListener listener, Integer plantID) {
        mValues = items;
        mListener = listener;
        mPlantID = plantID;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_plants, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(mPlantID > 0){
            //Force the scanned plant to show up in every slot on the viewholder, this allows auto click later
            position = mPlantID - 1;
        }
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }

        };
        holder.mView.setOnClickListener(listener);

        if(mPlantID > 0) {
            //PlantID was passed so force a click
            listener.onClick(holder.itemView);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
