package com.sungsu.JavaCore.beanfind;


import com.sungsu.JavaCore.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AnnotationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] definitionNames = ac.getBeanDefinitionNames(); //Bean names
        for (String definitionName : definitionNames) {
            Object bean = ac.getBean(definitionName); // Bean name values
            System.out.println("Bean Name = " + definitionName + " bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] definitionNames = ac.getBeanDefinitionNames(); //Bean names
        for (String definitionName : definitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(definitionName); // definitionName의 MetaData

            // ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(definitionName); // Bean name values
                System.out.println("Bean Name = " + definitionName + " bean = " + bean);
            }
        }
    }
}
