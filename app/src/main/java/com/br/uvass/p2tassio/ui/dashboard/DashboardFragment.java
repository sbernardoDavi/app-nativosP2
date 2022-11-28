package com.br.uvass.p2tassio.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.uvass.p2tassio.R;
import com.br.uvass.p2tassio.adapter.HouseAdapter;
import com.br.uvass.p2tassio.controller.Client;
import com.br.uvass.p2tassio.databinding.FragmentDashboardBinding;
import com.br.uvass.p2tassio.model.HouseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    View view;
    Toolbar toolbar;
    RecyclerView recyclerView;
    HouseAdapter houseAdapter;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);


        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        houseAdapter = new HouseAdapter();

        getAllHouses();
        return  view;
    }

    public void getAllHouses(){

        Call<List<HouseResponse>> housesList = Client.getHouseService().getAllHouses();
        housesList.enqueue(new Callback<List<HouseResponse>>() {
            @Override
            public void onResponse(Call<List<HouseResponse>> call, Response<List<HouseResponse>> response) {
                if (response.isSuccessful()){
                   List<HouseResponse> houseResponseList = response.body();

                   houseAdapter.setData(houseResponseList);
                   recyclerView.setAdapter(houseAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<HouseResponse>> call, Throwable t) {
                Log.e("falha", t.getLocalizedMessage());


            }
        });

    }
}