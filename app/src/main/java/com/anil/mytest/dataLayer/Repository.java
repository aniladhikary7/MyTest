package com.anil.mytest.dataLayer;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.anil.mytest.network.GetDataService;
import com.anil.mytest.network.RetrofitClientInstance;
import com.anil.mytest.userPayload.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {

    Context context;
    RecyclerView recyclerView;
    public Repository(Context applicationContext,RecyclerView recyclerView) {
        context=applicationContext;
        this.recyclerView=recyclerView;
    }

    public MutableLiveData<UserResponse> getTasks() {
        GetDataService service = RetrofitClientInstance
                .getRetrofitInstance()
                .create(GetDataService.class);
        Call<UserResponse> call = service.getAllUser();

        final MutableLiveData<UserResponse> newsData = new MutableLiveData<>();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                newsData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                System.out.println("onFailure");
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
