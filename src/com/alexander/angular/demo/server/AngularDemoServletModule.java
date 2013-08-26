package com.alexander.angular.demo.server;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
import java.util.HashMap;
import java.util.Map;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class AngularDemoServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("javax.ws.rs.Application", "com.alexander.angular.demo.server.AngularDemoRestApplication");
        serve("/rest/*").with(GuiceContainer.class, params);
    }
}
