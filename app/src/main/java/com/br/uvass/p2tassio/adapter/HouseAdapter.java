package com.br.uvass.p2tassio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.uvass.p2tassio.R;
import com.br.uvass.p2tassio.model.HouseResponse;



import java.util.List;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseAdapterVH> {

    private List<HouseResponse> houseResponseList;
    private Context context;

    public HouseAdapter(){

    }

    public void setData(List<HouseResponse> houseResponseList){
        this.houseResponseList = houseResponseList;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public HouseAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new HouseAdapter.HouseAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_houses, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HouseAdapterVH holder, int position) {

        HouseResponse houseResponse = houseResponseList.get(position);

        String name = houseResponse.getName();
        String founder = houseResponse.getFounder();


        holder.houseName.setText(name);
        holder.houseFounder.setText(founder);
        holder.houseImage.setImageResource(R.drawable.houses);
    }

    @Override
    public int getItemCount() {
        return houseResponseList.size();
    }

    public class HouseAdapterVH extends RecyclerView.ViewHolder {

        ImageView houseImage;
        TextView houseName;
        TextView houseFounder;



        public HouseAdapterVH(@NonNull View itemView) {
            super(itemView);

            houseImage = itemView.findViewById(R.id.houseImage);
            houseName = itemView.findViewById(R.id.houseName);
            houseFounder = itemView.findViewById(R.id.houseFounder);
        }
    }
}
