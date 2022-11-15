package com.sungsu.JavaCore.beanfind;

import com.sungsu.JavaCore.AppConfig;
import com.sungsu.JavaCore.member.MemberRepository;
import com.sungsu.JavaCore.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회할 때 중복되는 타입이 존재한다면 오류 발생")
    void findSameBeanByDuplication(){

        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("중복되는 빈이 존재하면 이름을 지정하면 된다.")
    void findBeanByName(){

        MemberRepository bean1 = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(bean1).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
            System.out.println("beansOfType = " + beansOfType);
            assertThat(beansOfType.size()).isEqualTo(2);
        }
    }

    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public  MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }

}
