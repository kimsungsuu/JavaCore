package com.sungsu.JavaCore.discount;

import com.sungsu.JavaCore.member.Grade;
import com.sungsu.JavaCore.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName(value = "VIP는 10% 할인이 적용되어야 한다.")
    public void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName(value = "Basic은 10% 할인이 적용되지 않아야 한다.")
    public void vip_x(){
        //given
        Member member = new Member(2L, "memberB", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}