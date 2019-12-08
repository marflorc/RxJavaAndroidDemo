package com.markcmd.rxjavaretrofitandroid.utils;

import com.markcmd.rxjavaretrofitandroid.callback.Callback;
import com.markcmd.rxjavaretrofitandroid.model.User;
import com.markcmd.rxjavaretrofitandroid.networking.utils.NetworkingUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserTask {
    public static void getUsers(final Callback<List<User>> callback){
        NetworkingUtils.getUserApiInstance()
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        callback.returnResult(users);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
