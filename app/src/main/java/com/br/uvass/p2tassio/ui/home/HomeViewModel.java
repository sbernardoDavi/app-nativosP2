package com.br.uvass.p2tassio.ui.dashboard;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.br.uvass.p2tassio.controller.Client;
import com.br.uvass.p2tassio.model.HouseResponse;
import com.br.uvass.p2tassio.model.SpellResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();

        Call<List<SpellResponse>> spellList = Client.getSpellService().getAllSpells();
        spellList.enqueue(new Callback<List<SpellResponse>>() {
            @Override
            public void onResponse(Call<List<SpellResponse>> call, Response<List<SpellResponse>> response) {
                if (response.isSuccessful()){
                    Log.e("sucesso", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<SpellResponse>> call, Throwable t) {
                Log.e("falha", t.getLocalizedMessage());


            }
        });

    }

    public LiveData<String> getText() {
        return mText;
    }
}