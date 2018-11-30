package edu.cascadia.emilio.foncfphoto_points.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //private static final int COUNT = 25;

    static {
        // use this at some point to increment the id
        // Add some sample items.
        //for (int i = 1; i <= COUNT; i++) {
            //addItem(createDummyItem(i));
        //}
        addItem(new DummyItem("1", "Douglas Fir", "Pseudotsuga menziesii", "Douglas-fir wood and bark was thought by most of the coastal groups to be an excellent fuel, but it had the reputation of throwing sparks and giving splinters to those handling it. The wood was also used to make items such as spear handles, harpoon shafts, spoons, dip-net poles, harpoon barbs, fire tongs, salmon weirs, caskets and halibut and cod hooks."));
        addItem(new DummyItem("2", "Black Twinberry", "Lonicera involucrata", ""));
        addItem(new DummyItem("3", "Red-oiser Dogwood", "Cornus sericea", ""));
        addItem(new DummyItem("4", "Thimbleberry", "Rubus parviflorus", ""));
        addItem(new DummyItem("5", "Sitka Spruce", "Picea sitchensis", ""));
        addItem(new DummyItem("6", "Slough Sedge", "Carex obnupta", ""));
        addItem(new DummyItem("7", "Clustered Rose", "Rosa pisocarpa", ""));
        addItem(new DummyItem("8", "Western Redcedar", "Thuja plicata", ""));
        addItem(new DummyItem("9", "Red Flowering Currant", "Ribes sanguineum", ""));
        addItem(new DummyItem("10", "Small-fruited Bulrush", "Scirpus microcarpus", ""));
        addItem(new DummyItem("11", "Low Oregon Grape", "Berberis nervosa", ""));
        addItem(new DummyItem("12", "Tall Oregon Grape", "Berberis aquifolium", ""));
        addItem(new DummyItem("13", "Pacific Ninebark", "Physocarpus capitatus", ""));
        addItem(new DummyItem("14", "Cascara", "Frangula purshiana", ""));
        addItem(new DummyItem("15", "Mock Orange", "Philadelphus lewisii", ""));
        addItem(new DummyItem("16", "Pacific Willow", "Salix lasiandra", ""));
        addItem(new DummyItem("17", "Black Cottonwood", "Populus trichocarpa", ""));
        addItem(new DummyItem("18", "Paper Birch", "Betula papyrifera", ""));
        addItem(new DummyItem("19", "Grand Fir", "Abies grandis", ""));
        addItem(new DummyItem("20", "Red Alder", "Alnus rubra", ""));
        addItem(new DummyItem("21", "Red Elderberry", "Sambucus racemosa", ""));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    //private static DummyItem createDummyItem(int position) {
        //return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    //}

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    // Talk with the team and change this later.
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final String info;

        public DummyItem(String id, String content, String details, String info) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.info = info;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
