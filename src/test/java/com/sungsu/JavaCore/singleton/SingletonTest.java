package com.sungsu.JavaCore.singleton;

import com.sungsu.JavaCore.AppConfig;
import com.sungsu.JavaCore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonTest {

    @Test
    @DisplayName("싱글톤이 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService).isNotSameAs(memberService2);
    }
}