package com.abich.db;

import com.abich.core.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> get(String id);

    void add(Member member);

    void update(Member orgMember);

    boolean contains(String id);

    List<Member> getAll();

    void delete(String id);
}
