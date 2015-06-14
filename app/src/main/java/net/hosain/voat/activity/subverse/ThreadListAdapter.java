package net.hosain.voat.activity.subverse;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class ThreadListAdapter<T> extends ArrayAdapter<Thread> {

    public ThreadListAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

}
