package com.markcmd.rxjavaretrofitandroid;

import com.markcmd.rxjavaretrofitandroid.callback.Callback;
import com.markcmd.rxjavaretrofitandroid.model.User;
import com.markcmd.rxjavaretrofitandroid.utils.UserTask;

import java.util.List;

public class UserPresenter implements UserContract.Presenter {

    UserContract.View mView;

    UserPresenter(UserContract.View mView){
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void loadUsers() {
        UserTask.getUsers(new Callback<List<User>>() {
            @Override
            public void returnResult(List<User> users) {
                mView.loadDataInList(users);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }
}
