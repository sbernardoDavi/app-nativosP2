package com.br.uvass.p2tassio.service;

import com.br.uvass.p2tassio.model.HouseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HouseService {

    @GET("houses/")
    Call<List<HouseResponse>> getAllHouses();

}
