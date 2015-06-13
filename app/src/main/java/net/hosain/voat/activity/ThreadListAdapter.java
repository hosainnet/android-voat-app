package net.hosain.voat.activity;

import android.content.Context;
import android.widget.ArrayAdapter;

import net.hosain.voat.data.Subverse;

import java.util.List;

public class ThreadListAdapter<T> extends ArrayAdapter<Thread> {

    private Subverse mSubverse;

    public ThreadListAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public Subverse getSubverse() {
        return mSubverse;
    }

    public void setSubverse(Subverse subverse) {
        this.mSubverse = subverse;
    }
}
