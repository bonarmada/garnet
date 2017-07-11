package com.bombon.garnet.service;

/**
 * Created by Vaughn on 7/10/17.
 */

public interface ServiceCallback<T> {
    void getResult(int statusCode, T result);
}
