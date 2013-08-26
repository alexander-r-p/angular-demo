package com.alexander.angular.demo.server;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
import com.alexander.angular.demo.server.dao.Dao;
import com.alexander.angular.demo.server.dao.PersonDao;
import com.alexander.angular.demo.server.model.Person;
import com.alexander.angular.demo.server.services.AbstractProvider;
import com.alexander.angular.demo.server.services.PersonProvider;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class AngularDemoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<Dao<Person>>() {}).to(PersonDao.class);
        bind(new TypeLiteral<AbstractProvider<Person>>() {}).to(PersonProvider.class);
    }
}
