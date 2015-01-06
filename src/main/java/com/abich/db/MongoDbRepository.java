package com.abich.db;

import com.abich.core.Member;
import com.abich.core.MemberBuilder;
import com.google.common.collect.Lists;
import com.mongodb.DB;
import org.mongojack.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class MongoDbRepository implements MemberRepository {

    public static final Logger LOGGER = LoggerFactory.getLogger(MongoDbRepository.class);

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
        MemberBuilder memberBuilder = new MemberBuilder()
                .clone(member).setId(null);
        WriteResult<Member, String> writeResult = getMemberCollection().insert(memberBuilder.createMember());
    }

    @Override
    public void update(@NotNull @Valid final Member orgMember) {
        DBCursor<Member> members = getMemberCollection().find().is("id", orgMember.getId());
        if (members.hasNext()) {
            Member member = members.next();
            WriteResult<Member, String> writeResult = getMemberCollection().updateById(orgMember.getId(), DBUpdate.push("name", orgMember.getName()));
        }
    }

    @Override
    public boolean contains(final String id) {
        return getMemberCollection().find().is("id", id) != null;
    }

    @Override
    public List<Member> getAll() {
        DBCursor<Member> memberDBCursor = getMemberCollection().find();

        return Lists.newArrayList((Iterable<Member>) memberDBCursor);
    }

    @Override
    public void delete(final String id) {
        WriteResult<Member, String> writeResult = getMemberCollection().remove(DBQuery.is("_id", id));
        LOGGER.info("Deleted {} members.", writeResult.getN());
    }
}
