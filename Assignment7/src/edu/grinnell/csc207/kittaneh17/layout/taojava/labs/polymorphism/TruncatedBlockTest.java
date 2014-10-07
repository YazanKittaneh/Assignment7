package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

/**
 * Test for TruncatedBlock
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */

import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.Test;

public class TruncatedBlockTest
{

  @Test
  public void test() throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out,true);
        
      TextLine tb1 = new TextLine("Hello");
      TextLine tb2 = new TextLine("World");
      TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(
          new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
      pen.println("ORIGINAL");
      TBUtils.print(pen, compound);
      tb2.setContents("Someone");
      pen.println("UPDATED");
      TBUtils.print(pen, compound);
      tb1.setContents("Nice to meet you,");
      pen.println("RE-UPDATED");
      TBUtils.print(pen, compound);
  }

}
