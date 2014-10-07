package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.Test;

public class TruncatedBlockTest
{

  @Test
  public void test()
  {
    PrintWriter pen = new PrintWriter(System.out,true);
        
      TextLine tb1 = new TextLine("Hello");
      TextLine tb2 = new TextLine("World");
      TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(
          new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
      pen.println("ORIGINAL");
      TBUtils.print(pen, compound);
      try{
      tb2.setContents("Someone");
      }
      catch (Exception e)
      {
        System.out.println("doesn't work");
      }
      pen.println("UPDATED");
      TBUtils.print(pen, compound);
      try{
      tb1.setContents("Nice to meet you,");
      }
      catch (Exception e)
      {
        System.out.println("doesn't work");
      }
      pen.println("RE-UPDATED");
      TBUtils.print(pen, compound);
  }

}
