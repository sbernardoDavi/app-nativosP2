package com.br.uvass.p2tassio.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.uvass.p2tassio.R;
import com.br.uvass.p2tassio.adapter.SpellAdapter;
import com.br.uvass.p2tassio.controller.Client;
import com.br.uvass.p2tassio.model.SpellResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    View view;
    Toolbar toolbar;
    RecyclerView recyclerView;
    SpellAdapter spellAdapter;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        spellAdapter = new SpellAdapter();

        getAllSpells();
        return  view;
    }

    public void getAllSpells(){

        Call<List<SpellResponse>> spellsList = Client.getSpellService().getAllSpells();
        spellsList.enqueue(new Callback<List<SpellResponse>>() {
            @Override
            public void onResponse(Call<List<SpellResponse>> call, Response<List<SpellResponse>> response) {
                if (response.isSuccessful()){
                    List<SpellResponse> spellResponseList = response.body();

                    spellAdapter.setData(spellResponseList);
                    recyclerView.setAdapter(spellAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<SpellResponse>> call, Throwable t) {
                Log.e("falha", t.getLocalizedMessage());


            }
        });

    }


}