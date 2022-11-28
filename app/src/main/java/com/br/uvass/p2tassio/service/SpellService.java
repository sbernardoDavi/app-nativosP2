package com.br.uvass.p2tassio.service;

import com.br.uvass.p2tassio.model.SpellResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpellService {

    @GET("Spells/")
    Call<List<SpellResponse>> getAllSpells();
}
