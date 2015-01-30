package com.abich;

import com.abich.auth.BasicAuthenticator;
import com.abich.config.DbConfigurationService;
import com.abich.config.MembershipManagerConfiguration;
import com.abich.core.User;
import com.abich.db.MemberRepository;
import com.abich.resources.MemberResource;
import com.abich.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.net.UnknownHostException;

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
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    @Override
    public void run(MembershipManagerConfiguration configuration, Environment environment)
            throws UnknownHostException {
        MemberRepository memberRepository = getMemberDbAdapter(configuration);
        MemberResource memberResource = new MemberResource(memberRepository);
        MembershipManagerHealthCheck membershipManagerHealthCheck = new MembershipManagerHealthCheck();

        environment.healthChecks().register("base", membershipManagerHealthCheck);
        environment.jersey().register(memberResource);
        UserResource userResource = new UserResource();
        environment.jersey().register(userResource);

        BasicAuthenticator basicAuthenticator
                = new BasicAuthenticator(configuration.getAdminUsername(), configuration.getAdminPassword());
        BasicAuthFactory<User> membershipManager
                = new BasicAuthFactory<>(basicAuthenticator, "MembershipManager", User.class);
        environment.jersey().register(AuthFactory.binder(membershipManager));
    }

    private MemberRepository getMemberDbAdapter(final MembershipManagerConfiguration configuration)
            throws UnknownHostException {
        DbConfigurationService dbConfigurationService = configuration.getDbConfigurationServiceFactory().build();
        dbConfigurationService.init();
        return dbConfigurationService.getMemberDbAdapter();
    }
}
