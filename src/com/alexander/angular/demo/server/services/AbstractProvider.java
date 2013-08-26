package com.alexander.angular.demo.server.services;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.alexander.angular.demo.server.dao.Dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public abstract class AbstractProvider<T> {

    @Inject
    private Dao<T> dao;

    private final Class<T> clazz;

    public AbstractProvider(Class<T> clazz) {
        this.clazz = clazz;
    }

    @GET
    @Path("/get/{id}")
    public String get(@PathParam("id") String id) {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if ("all".equals(id)) {
            return gson.toJson(dao.findAll().toArray());
        } else {
            return gson.toJson(dao.find(Long.valueOf(id)));
        }
    }

    @POST
    @Path("/persist")
    public void persist(String body) {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final T t = gson.fromJson(body, clazz);
        dao.persist(t);
    }
}