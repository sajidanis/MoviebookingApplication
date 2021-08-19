package com.sajid.moviebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class is used to demo testing
 * JUnit Framework functionality
 */
public class TestDemo {

    @BeforeEach
    public void beforeEachTestMethod(){
        System.out.println("Before each test");
    }

    @Test
    public void myFirstTest(){
        System.out.println("Insider the first test");
    }
}
