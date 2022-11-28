package com.br.uvass.p2tassio.ui.dashboard;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.br.uvass.p2tassio.controller.Client;
import com.br.uvass.p2tassio.model.HouseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();

        Call<List<HouseResponse>> housesList = Client.getHouseService().getAllHouses();
        housesList.enqueue(new Callback<List<HouseResponse>>() {
            @Override
            public void onResponse(Call<List<HouseResponse>> call, Response<List<HouseResponse>> response) {
                if (response.isSuccessful()){
                    Log.e("sucesso", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<HouseResponse>> call, Throwable t) {
                Log.e("falha", t.getLocalizedMessage());


            }
        });

    }

    public LiveData<String> getText() {
        return mText;
    }
}