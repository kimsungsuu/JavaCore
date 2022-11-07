package com.sungsu.JavaCore;

import com.sungsu.JavaCore.member.Grade;
import com.sungsu.JavaCore.member.Member;
import com.sungsu.JavaCore.member.MemberService;
import com.sungsu.JavaCore.member.MemberServiceImpl;
import com.sungsu.JavaCore.order.Order;
import com.sungsu.JavaCore.order.OrderService;
import com.sungsu.JavaCore.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order : " + order);

    }
}
