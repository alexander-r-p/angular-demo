package com.alexander.angular.demo.server.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alexander.angular.demo.server.model.Person;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public abstract class AbstractDao<T> extends DAOBase implements Dao<T> {

    static {
        ObjectifyService.register(Person.class);
    }

    private final Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T find(Long id) {
        return ObjectifyService.begin().find(clazz, id);
    }

    @Override
    public T find(String id) {
        return ObjectifyService.begin().find(clazz, id);
    }

    @Override
    public T find(Key<T> key) {
        return ObjectifyService.begin().find(key);
    }

    @Override
    public Key<T> key(T t) {
        return ObjectifyService.factory().getKey(t);
    }

    @Override
    public List<T> findAll() {
        return ObjectifyService.begin().query(clazz).list();
    }

    @Override
    public List<T> findAll(List<Key<T>> keys) {
        if (keys == null) {
            return null;
        }
        final Map<Key<T>, T> map = ObjectifyService.begin().get(keys);
        final List<T> list = new ArrayList<T>();
        for (final T t : map.values()) {
            list.add(t);
        }
        return list;
    }

    @Override
    public List<Key<T>> key(List<T> list) {
        if (list == null) {
            return null;
        }
        final List<Key<T>> keys = new ArrayList<Key<T>>(list.size());
        for (final T t : list) {
            final Key<T> key = ObjectifyService.factory().getKey(t);
            keys.add(key);
        }
        return keys;
    }

    @Override
    public T persist(T t) {
        ObjectifyService.begin().put(t);
        return t;
    }

    @Override
    public void delete(T t) {
        ObjectifyService.begin().delete(t);
    }
}