package com.abich;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by perab_000 on 11.12.2014.
 */
public class MembershipManagerHealthCheck extends HealthCheck {
    public MembershipManagerHealthCheck() {
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
