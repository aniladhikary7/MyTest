package com.anil.mytest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.anil.mytest.R;
import com.anil.mytest.userPayload.UserResponse;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        recyclerView = findViewById(R.id.customRecyclerView);
        setupViewModel();
    }

    private void setupViewModel() {
        MainViewModelFactory factory = new MainViewModelFactory(this,recyclerView);
        MainViewModel viewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);

        viewModel.getTasks().observe(this,  new Observer<UserResponse>(){
            @Override
            public void onChanged(UserResponse userResponse) {
                if(userResponse.getData() == null){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,
                            "Something went wrong...Please try later!",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.dismiss();
                    generateDataList( userResponse );
                }
            }
        });
    }

    private void generateDataList( UserResponse userResponse) {
        CustomAdapter adapter;
        adapter = new CustomAdapter(this, userResponse.getData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}