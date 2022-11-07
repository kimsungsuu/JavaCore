package com.sungsu.JavaCore.discount;

import com.sungsu.JavaCore.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int itemPrice);
}
