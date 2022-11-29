package com.sungsu.JavaCore.singleton;

import com.sungsu.JavaCore.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);

        //thread1 10000won
        int userA = statefulService.order("userA", 10000);
        //thread2 20000won
        int userB = statefulService1.order("userB", 20000);

//        int price = statefulService.getPrice();
        System.out.println("user A price = " + userA);

        Assertions.assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}