package com.gl.ideas_app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestReminder {

  @BeforeAll
  public static void inBeginning(){
    System.out.println("The very first thing");
  }

  @AfterAll
  public static void inEnd(){
    System.out.println("The very last thing");
  }


  @BeforeEach
  public void preSetup(){
    System.out.println("Before each test");

    /**
     * When should we use this annotation ?
     */
  }

  @AfterEach
  public void postTestExecution(){
    System.out.println("After each test");
  }
  @Test
  public void test1(){
    System.out.println("First test");

  }

  @Test
  public void test2(){
    System.out.println("Second test");

  }



}
