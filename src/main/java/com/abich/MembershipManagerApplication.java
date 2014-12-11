package com.abich;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by h76 on 10.12.2014.
 */
public class MembershipManagerApplication extends Application<MembershipManagerConfiguration> {
    public static void main(String[] args) throws Exception {
        new MembershipManagerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<MembershipManagerConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/gui", "index.html"));
    }

    @Override
    public void run(MembershipManagerConfiguration configuration, Environment environment) {
        MemberResource memberResource = new MemberResource();
        MembershipManagerHealthCheck membershipManagerHealthCheck = new MembershipManagerHealthCheck();

        environment.healthChecks().register("base",membershipManagerHealthCheck);
        environment.jersey().register(memberResource);
    }
}
