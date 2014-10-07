package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

/**
 * Test for CenteredBlock
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */

import java.io.PrintWriter;

import org.junit.Test;

public class CenteredBlockTest
{

  @Test
  public void test()
  {
    PrintWriter pen = new PrintWriter(System.out,true);
    TextBlock block = 
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
      TextBlock block2 = new BoxedBlock(new CenteredBlock(block, 4));
      TBUtils.print(pen, block2);
  }

}
