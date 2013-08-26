package com.alexander.angular.demo.server;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import com.alexander.angular.demo.server.model.Person;
import com.alexander.angular.demo.server.services.AbstractProvider;

@Path("/rest")
public class AngularDemoRestApplication extends Application {

    @Inject
    AbstractProvider<Person> personService;

    @Override
    public Set<Object> getSingletons() {
        return new HashSet<Object>(Arrays.asList(new Object[] { personService }));
    }
}
