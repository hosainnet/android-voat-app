package net.hosain.voat.activity.subverse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.hosain.voat.R;
import net.hosain.voat.data.DataEntity;

import java.util.List;

public class SubverseAdapter extends RecyclerView.Adapter<SubverseAdapter.DetailItemViewHolder> {

    private List<DataEntity> mThreads;
    private Context mContext;

    public SubverseAdapter(Context context, List<DataEntity> threads) {
        this.mThreads = threads;
        this.mContext = context;
    }

    @Override
    public DetailItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_subverse_list_item, parent, false);
        return new DetailItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailItemViewHolder holder, int position) {
        holder.mTitleView.setText(mThreads.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mThreads.size();
    }

    public static class DetailItemViewHolder extends RecyclerView.ViewHolder {

        protected ImageView mImageView;
        protected TextView mTitleView;

        public DetailItemViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.subverse_item_image);
            this.mTitleView = (TextView) itemView.findViewById(R.id.subverse_item_title);
        }
    }

}
