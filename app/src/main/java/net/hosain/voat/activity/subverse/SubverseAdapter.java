package net.hosain.voat.activity.subverse;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class SubverseAdapter<T> extends ArrayAdapter<Thread> {

    public SubverseAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

}
