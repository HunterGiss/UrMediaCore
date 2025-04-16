package com.urmedia.database.dao;

public abstract class PostrgresDao<T> implements Dao<T> {

    @Override
    public void putItem(T item) {

    }

    @Override
    public T getItem(String primaryKey) {
        return null;
    }
}
