package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

/**
 * Test of Grid
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */

import java.io.PrintWriter;

import org.junit.Test;

public class GridTest
{

  @Test
  public void test()
  {
    PrintWriter pen = new PrintWriter(System.out,true);
    TBUtils.print(pen, new BoxedBlock(new Grid(100, 100, '*')));
  }

}
