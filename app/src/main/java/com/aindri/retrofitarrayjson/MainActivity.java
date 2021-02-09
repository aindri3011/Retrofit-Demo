package com.aindri.retrofitarrayjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    ArrayList<Model> arrayList=new ArrayList<>();
    RecyclerView reclycler1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reclycler1=findViewById(R.id.recycler1);
        arrayList=new ArrayList<>();


        retrofit=new Retrofit.Builder()
                .baseUrl("Put raw part of url")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroApi retroApi=retrofit.create(RetroApi.class);


        Call<JsonArray> call=retroApi.getListData();

       call.enqueue(new Callback<JsonArray>() {
           @Override
           public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

               JsonArray jsonArray = response.body();
               arrayList =new ArrayList<>(Arrays.asList(jsonArray.getModelarray()));

               PutDataIntoRecyclerView(arrayList);
           }

           @Override
           public void onFailure(Call<JsonArray> call, Throwable t) {

           }
       });
    }
    private void PutDataIntoRecyclerView(ArrayList<Model> arrayList) {
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(MainActivity.this,arrayList);
        reclycler1.setLayoutManager(new LinearLayoutManager(this));
        reclycler1.setAdapter(recyclerAdapter);

    }
}