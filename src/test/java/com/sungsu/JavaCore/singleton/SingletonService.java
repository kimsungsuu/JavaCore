package com.sungsu.JavaCore.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    /**
     * 조회
     */
    public static SingletonService getInstance(){
        return instance;
    }

    /**
     * 외부에서 선언하지 못하도록 private 생성자 생성
     */
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }
}
