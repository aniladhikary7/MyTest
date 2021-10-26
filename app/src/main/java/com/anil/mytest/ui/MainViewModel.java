package com.anil.mytest.ui;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.anil.mytest.dataLayer.Repository;
import com.anil.mytest.userPayload.UserResponse;

public class MainViewModel extends ViewModel {
    Repository repository;

    public MainViewModel(Context context, RecyclerView recyclerView) {
        repository = new Repository(context,recyclerView);
    }

    public MutableLiveData<UserResponse> getTasks() {
        return repository.getTasks();
    }
}
