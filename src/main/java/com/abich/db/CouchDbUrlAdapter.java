package com.abich.db;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.URL;

/**
 * Created by abichper on 13.12.2014.
 */
public class CouchDbUrlAdapter implements CouchDbAdapter {
    @Override
    public CouchDbConnector getConnector(final URL couchDbUrl, final String databaseName) {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url(couchDbUrl)
                .build();

        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        CouchDbConnector db = new StdCouchDbConnector(databaseName, dbInstance);

        db.createDatabaseIfNotExists();
        return db;
    }
}
