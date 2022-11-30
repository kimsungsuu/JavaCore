package com.sungsu.JavaCore.discount;

import com.sungsu.JavaCore.member.Grade;
import com.sungsu.JavaCore.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int itemPrice) {
        if(member.getGrade() == Grade.VIP){
            return itemPrice*discountPercent/100;
        }

        return 0;
    }
}
