package com.abich.db;

import com.abich.core.Member;
import com.mongodb.DB;
import org.mongojack.DBCursor;
import org.mongojack.DBUpdate;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    /**
     * Saves member as a new member (even if it has been saved before).
     *
     * @param member
     */
    @Override
    public void add(@NotNull final Member member) {
        member.setId(null);
        WriteResult<Member, String> writeResult = getMemberCollection().insert(member);
        member.setId(writeResult.getSavedId());
    }

    @Override
    public void update(@NotNull @Valid final Member orgMember) {
        DBCursor<Member> members = getMemberCollection().find().is("id", orgMember.getId());
        if (members.hasNext()) {
            Member member = members.next();
            getMemberCollection().updateById(orgMember.getId(), DBUpdate.push("name", orgMember.getName()));
        }
    }

    @Override
    public boolean contains(final String id) {
        return getMemberCollection().find().is("id", id)!=null;
    }
}
