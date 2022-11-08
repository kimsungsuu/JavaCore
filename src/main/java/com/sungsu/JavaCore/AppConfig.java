package com.sungsu.JavaCore;

import com.sungsu.JavaCore.discount.DiscountPolicy;
import com.sungsu.JavaCore.discount.FixDiscountPolicy;
import com.sungsu.JavaCore.discount.RateDiscountPolicy;
import com.sungsu.JavaCore.member.MemberRepository;
import com.sungsu.JavaCore.member.MemberService;
import com.sungsu.JavaCore.member.MemberServiceImpl;
import com.sungsu.JavaCore.member.MemoryMemberRepository;
import com.sungsu.JavaCore.order.OrderService;
import com.sungsu.JavaCore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
        // 내가 만든 MemberServiceImpl은 MemoryMemberRepository를 사용할거야.라고 해석하면 편하다.
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
