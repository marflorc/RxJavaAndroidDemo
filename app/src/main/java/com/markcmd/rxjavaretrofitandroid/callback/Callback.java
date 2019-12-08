package com.markcmd.rxjavaretrofitandroid.callback;

public interface Callback<T> {
    void returnResult(T t);
    void returnError(String message);
}
