package com.aindri.retrofitarrayjson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroApi {
    @GET("put variable part of url")
    Call<JsonArray> getListData();
}
