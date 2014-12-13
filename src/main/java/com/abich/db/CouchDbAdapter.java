package com.abich.db;

import org.ektorp.CouchDbConnector;

import java.net.URL;

/**
 * Created by abichper on 13.12.2014.
 */
public interface CouchDbAdapter {
    CouchDbConnector getConnector(URL couchDbUrl, String databaseName);
}
