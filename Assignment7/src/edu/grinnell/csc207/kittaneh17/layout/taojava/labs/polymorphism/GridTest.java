package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

//import static org.junit.Assert.*;

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
