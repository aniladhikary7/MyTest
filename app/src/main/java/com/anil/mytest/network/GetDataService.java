package com.anil.mytest.network;

import com.anil.mytest.userPayload.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("users")
    Call<UserResponse> getAllUser();
}
