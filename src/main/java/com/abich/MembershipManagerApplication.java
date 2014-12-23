package com.abich;

import com.abich.config.DbConfigurationService;
import com.abich.config.MembershipManagerConfiguration;
import com.abich.db.MemberRepository;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
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
    public void run(MembershipManagerConfiguration configuration, Environment environment) throws UnknownHostException {
        MemberRepository memberRepository = getMemberDbAdapter(configuration);
        MemberResource memberResource = new MemberResource(memberRepository);
        MembershipManagerHealthCheck membershipManagerHealthCheck = new MembershipManagerHealthCheck();

        environment.healthChecks().register("base", membershipManagerHealthCheck);
        environment.jersey().register(memberResource);
    }

    private MemberRepository getMemberDbAdapter(final MembershipManagerConfiguration configuration) throws UnknownHostException {
        DbConfigurationService dbConfigurationService = configuration.getDbConfigurationServiceFactory().build();
        dbConfigurationService.init();
        return dbConfigurationService.getMemberDbAdapter();
    }
}
