package com.markcmd.rxjavaretrofitandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.markcmd.rxjavaretrofitandroid.adapter.CustomAdapter;
import com.markcmd.rxjavaretrofitandroid.model.User;

import java.util.List;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    private UserContract.Presenter mPresenter;
    private RecyclerView recyclerview;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mPresenter = new UserPresenter(this);
        mPresenter.start();
    }

    @Override
    public void init() {
        recyclerview = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        mPresenter.loadUsers();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadDataInList(List<User> users) {
        adapter = new CustomAdapter(users);
        recyclerview.setAdapter(adapter);
    }
}
