package com.testcase3;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestJUnit5 {
    @Test
    public void demo(){
        assertEquals(1,2);
        System.out.println("1");
        System.out.println("2");
    }
}
