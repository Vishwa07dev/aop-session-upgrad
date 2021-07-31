package com.gl.ideas_app.service.serviceImpl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HCLTestDemo {

  @BeforeAll
  public static void beforeAll(){
    System.out.println("Starting");
  }

  @AfterAll
  public static void afterAll(){
    System.out.println("Stopping");
  }


  @BeforeEach
  public void beforeEach(){
    System.out.println("Before each test is run");
  }

  @AfterEach
  public void afterEach(){
    System.out.println("After each test is run");
  }

  @Test
  public void test1(){
    System.out.println("Hello Testing");
  }


  @Test
  public void test2(){
    System.out.println("Hello Testing Again");
  }



}
