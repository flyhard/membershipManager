package com.abich.config;

import com.abich.db.MemberRepository;
import com.abich.db.MongoDbRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;

import javax.validation.constraints.NotNull;
import java.net.UnknownHostException;

public class MongoDbConfigurationService implements DbConfigurationService {
    @NotNull
    @JsonProperty
    private String dbName;
    @NotNull
    @JsonProperty
    private String host;
    @NotNull
    @JsonProperty
    private Integer port;
    private DB db;

    public MongoDbConfigurationService(final String dbName, final String host, final Integer port, final DB db) {
        this.dbName = dbName;
        this.host = host;
        this.port = port;
        this.db = db;
    }

    public MongoDbConfigurationService() {
    }

    @Override
    public MemberRepository getMemberDbAdapter() {
        return new MongoDbRepository(db);
    }

    @Override
    public void init() throws UnknownHostException {
        ServerAddress serverAddress = new ServerAddress(getHost(), getPort());
        Mongo mongo = new Mongo(serverAddress);
        db = mongo.getDB(getDbName());
    }

    public String getDbName() {
        return dbName;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }
}
