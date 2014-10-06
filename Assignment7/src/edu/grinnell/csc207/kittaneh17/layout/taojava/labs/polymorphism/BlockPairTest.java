package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.Test;

public class BlockPairTest
{

  @Test
  public void test()
  {
    PrintWriter pen = new PrintWriter(System.out,true);
    TextBlock block = 
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
      TextBlock block2 = new BoxedBlock(new BlockPair(block));
      TBUtils.print(pen, block2);
  }

}
 