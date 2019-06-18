package com.dicoding.myiwaku;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GiftShopAdapter extends RecyclerView.Adapter<GiftShopAdapter.GiftViewHolder> {

    private Context context;

    private ArrayList<Shop> listShop;

    public ArrayList<Shop> getListShop() {
        return listShop;
    }

    public void setListShop(ArrayList<Shop> listShop) {
        this.listShop = listShop;
    }

    public GiftShopAdapter(Context context) {
        this.context = context;
    }




    @NonNull
    @Override
    public GiftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gift_shop, parent, false);
        return new GiftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftViewHolder holder, int position) {
        Glide.with(context)
                .load(getListShop().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListShop().size();
    }

    public class GiftViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GiftViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
