package com.valdioveliu.valdio.mobileadsexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Valdio Veliu on 16-09-01.
 */
public class RV_Adapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int ITEM = 0;
    private static final int NATIVE_AD = 1;
    int[] viewTypes;
    List<Data> list = Collections.emptyList();

    public RV_Adapter(List<Data> list, int[] viewTypes) {
        this.list = list;
        this.viewTypes = viewTypes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v;
        if (viewType == ITEM) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            ViewHolder holder = new ItemViewHolder(v);
            return holder;
        } else if (viewType == NATIVE_AD) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_ad, parent, false);
            ViewHolder holder = new AdViewHolder(v);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (viewHolder.getItemViewType() == ITEM) {
            ItemViewHolder holder = (ItemViewHolder) viewHolder;
            //populate the RecyclerView
            //holder.title.setText(list.get(position).getTitle());
            //holder.description.setText(list.get(position).getDescription());
        } else if (viewHolder.getItemViewType() == NATIVE_AD) {
            AdViewHolder holder = (AdViewHolder) viewHolder;
            //Load the Ad
            AdRequest request = new AdRequest.Builder()
                    .build();
            holder.adView.loadAd(request);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes[position];
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View v) {
        super(v);
    }
}

class ItemViewHolder extends ViewHolder {

    TextView title;
    TextView description;

    ItemViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.itemTitle);
        description = (TextView) itemView.findViewById(R.id.itemDescription);
    }
}

class AdViewHolder extends ViewHolder {
    NativeExpressAdView adView;

    public AdViewHolder(View v) {
        super(v);
        adView = (NativeExpressAdView) v.findViewById(R.id.nativeAdView);
    }
}