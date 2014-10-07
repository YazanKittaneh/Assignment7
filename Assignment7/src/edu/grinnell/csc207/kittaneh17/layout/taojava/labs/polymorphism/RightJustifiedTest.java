package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

/**
 * Test for RightJustified
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */

import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.Test;

public class RightJustifiedTest
{

  @Test
  public void test()
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    TextBlock block =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new BoxedBlock(new RightJustified(block, 6));
    TBUtils.print(pen, block2);
  }

}
