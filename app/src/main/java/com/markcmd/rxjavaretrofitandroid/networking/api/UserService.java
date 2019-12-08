package com.markcmd.rxjavaretrofitandroid.networking.api;

import com.markcmd.rxjavaretrofitandroid.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserService {

    @GET("/posts/")
    Observable<List<User>> getUsers();

}
