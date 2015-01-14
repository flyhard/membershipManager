package com.abich.config;

import com.abich.db.MemberRepository;

import java.net.UnknownHostException;

public interface DbConfigurationService {
    MemberRepository getMemberDbAdapter();

    void init() throws UnknownHostException;
}
