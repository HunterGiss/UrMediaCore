package com.urmedia.database.dao;

public interface Dao<T> {
    void putItem(T item);

    T getItem(String primaryKey);
}
