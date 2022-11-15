package com.sungsu.JavaCore.beanfind;

import com.sungsu.JavaCore.discount.DiscountPolicy;
import com.sungsu.JavaCore.discount.FixDiscountPolicy;
import com.sungsu.JavaCore.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ExtendBeanConfig.class);

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType(){
        Map<String, Object> beanOfType = ac.getBeansOfType(Object.class);
        for(String key : beanOfType.keySet()){
            System.out.println("key = " + key + " value = " + beanOfType.get(key));
        }
    }

    @Configuration
    static class ExtendBeanConfig{

        @Bean
        public DiscountPolicy rateDiscount(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscount(){
            return new FixDiscountPolicy();
        }
    }
}
