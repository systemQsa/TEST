package com.myproject.dao;

import java.util.List;

public interface DAO <T>{
    List<T> findAll(T t);
    T findById(T t);
    T deleteById(T t);
    T update(T t);
}
