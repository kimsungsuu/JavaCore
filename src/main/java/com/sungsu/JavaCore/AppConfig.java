package com.sungsu.JavaCore;

import com.sungsu.JavaCore.discount.FixDiscountPolicy;
import com.sungsu.JavaCore.member.MemberService;
import com.sungsu.JavaCore.member.MemberServiceImpl;
import com.sungsu.JavaCore.member.MemoryMemberRepository;
import com.sungsu.JavaCore.order.OrderService;
import com.sungsu.JavaCore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
        // 내가 만든 MemberServiceImpl은 MemoryMemberRepository를 사용할거야.라고 해석하면 편하다.
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
