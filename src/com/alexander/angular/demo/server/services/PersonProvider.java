package com.alexander.angular.demo.server.services;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
import javax.ws.rs.Path;

import com.alexander.angular.demo.server.model.Person;

@Path("/person")
public class PersonProvider extends AbstractProvider<Person> {

    public PersonProvider() {
        super(Person.class);
    }
}
