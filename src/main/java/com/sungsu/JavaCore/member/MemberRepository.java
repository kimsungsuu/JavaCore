package com.sungsu.JavaCore.member;

import com.sungsu.JavaCore.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
