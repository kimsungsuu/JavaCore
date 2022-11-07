package com.sungsu.JavaCore.member;

import com.sungsu.JavaCore.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
