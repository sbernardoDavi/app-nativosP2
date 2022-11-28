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
import com.br.uvass.p2tassio.model.SpellResponse;


import java.util.List;

public class SpellAdapter extends RecyclerView.Adapter<SpellAdapter.SpellAdapterVH> {

    private List<SpellResponse> spellResponseList;
    private Context context;

    public SpellAdapter(){

    }

    public void setData(List<SpellResponse> spellResponseList){
        this.spellResponseList = spellResponseList;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public SpellAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SpellAdapter.SpellAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_spells, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpellAdapterVH holder, int position) {

        SpellResponse spellResponse = spellResponseList.get(position);

        String name = spellResponse.getName();
        String incantation = spellResponse.getIncantation();
        String idSpell = spellResponse.getId();

        holder.spellName.setText(name);
        holder.spellIncantation.setText(incantation);

    }

    @Override
    public int getItemCount() {
        return spellResponseList.size();
    }

    public class SpellAdapterVH extends RecyclerView.ViewHolder {

        TextView spellName;
        TextView spellIncantation;

        public SpellAdapterVH(@NonNull View itemView) {
            super(itemView);


            spellName = itemView.findViewById(R.id.spellName);
            spellIncantation = itemView.findViewById(R.id.spellIncantation);
        }
    }
}
