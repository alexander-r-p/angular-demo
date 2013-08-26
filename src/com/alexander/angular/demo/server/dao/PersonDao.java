package com.alexander.angular.demo.server.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
import com.alexander.angular.demo.server.model.Person;

public class PersonDao extends AbstractDao<Person> {

    public PersonDao() {
        super(Person.class);
    }
}
