package com.abich.db;

import com.abich.core.Member;
import com.mongodb.DB;
import org.mongojack.JacksonDBCollection;

import java.util.Optional;

public class MongoDbRepository implements MemberRepository {

    private final DB db;

    public MongoDbRepository(final DB db) {
        this.db = db;
    }

    @Override
    public Optional<Member> get(final String id) {
        org.mongojack.DBCursor<Member> cursor = getMemberCollection().find().is("id", id);
        if (cursor.hasNext()) {
            return Optional.of(cursor.next());
        }
        return Optional.empty();
    }

    private JacksonDBCollection<Member, String> getMemberCollection() {
        return JacksonDBCollection.wrap(db.getCollection("member"), Member.class,
                String.class);
    }

    @Override
    public void add(final Member member) {

    }

    @Override
    public void update(final Member orgMember) {

    }

    @Override
    public boolean contains(final String id) {
        return false;
    }
}
