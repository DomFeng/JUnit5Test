package com.testcase;
import org.junit.jupiter.api.*;
@DisplayName("JUnit5演示类")
public class Junit5Demo1Test {
    @BeforeAll
    public static void before(){
        System.out.println("before");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @Test
    @DisplayName("fun1 测试方法")
    @RepeatedTest(5)
    public void fun1(){
        System.out.println("fun1");
    }
    @DisplayName("fun2 测试方法")
    @Test
    public void fun2(){
        System.out.println("fun2");
    }
    @Test
    @Tag("fun3Demo")
    public void fun3(){
        System.out.println("fun3");
    }
    @Test
    @Tag("fun4Demo")
    public void fun4(){
        System.out.println("fun4");
    }
    @AfterAll
    public static void after(){
        System.out.println("after");
    }
}
