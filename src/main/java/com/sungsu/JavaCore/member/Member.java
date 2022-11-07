package com.sungsu.JavaCore.member;

import com.sungsu.JavaCore.member.Grade;

public class Member {

    private Long id;

    private String name;

    private Grade grade;

    public Member(Long id, String name, Grade grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
