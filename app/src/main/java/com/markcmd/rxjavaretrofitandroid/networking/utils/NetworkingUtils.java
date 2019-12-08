package com.markcmd.rxjavaretrofitandroid.networking.utils;

import com.markcmd.rxjavaretrofitandroid.networking.adapter.RetrofitAdapter;
import com.markcmd.rxjavaretrofitandroid.networking.api.UserService;

public class NetworkingUtils {

    private static UserService userService;

    public static UserService getUserApiInstance(){
        if(userService == null)
            userService = RetrofitAdapter.getInstance().create(UserService.class);

        return userService;
    }
}
