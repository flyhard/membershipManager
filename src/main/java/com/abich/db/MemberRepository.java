package com.abich.db;

import com.abich.core.Member;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

public class MemberRepository extends CouchDbRepositorySupport<Member> {

    public MemberRepository(CouchDbConnector db) {
        super(Member.class, db);
    }

}