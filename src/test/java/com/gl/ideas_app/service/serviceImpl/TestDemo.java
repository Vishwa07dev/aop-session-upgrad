package com.gl.ideas_app.service.serviceImpl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestDemo {


  @BeforeAll
  public static void begin(){
    System.out.println("Test begins");
  }

  @AfterAll
  public static void end(){
    System.out.println("Test ends");
  }


  @Test
  public void firstTestMethod(){
    System.out.println("First Test");
  }

  @Test
  public void secondTestMethod(){
    System.out.println("Second Test");
  }


  @BeforeEach
  public void beforeEachTest(){
    System.out.println("Before each test");
  }


  @AfterEach
  public void afterEachTest(){
    System.out.println("After each test");
  }


}
