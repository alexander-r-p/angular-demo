package com.alexander.angular.demo.server.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;

import com.googlecode.objectify.Key;

public interface Dao<T> {

    T find(Long id);

    T find(String id);

    T find(Key<T> key);

    Key<T> key(T t);

    List<T> findAll();

    List<T> findAll(List<Key<T>> keys);

    List<Key<T>> key(List<T> list);

    T persist(T t);

    void delete(T t);
}