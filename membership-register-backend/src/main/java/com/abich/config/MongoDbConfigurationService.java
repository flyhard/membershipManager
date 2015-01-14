package com.abich.config;

import com.abich.db.MemberRepository;
import com.abich.db.MongoDbRepository;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;

public class MongoDbConfigurationService implements DbConfigurationService {
    private String dbName;
    private String host;
    private Integer port;
    private DB db;

    public MongoDbConfigurationService(final String dbName, final String host, final Integer port) {
        this.dbName = dbName;
        this.host = host;
        this.port = port;
        this.db = db;
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
