package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;


/**
 * Represents two copies of the same block, side by side
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */
public class BlockPair
    implements TextBlock
{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock textPair;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new pair block
   * 
   * @param tb , a textblock
   */
  public BlockPair(TextBlock tb)
  {
    this.textPair = tb;
  } //BlockPair (TextBlock tb)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the ith row of the block
   */
  @Override
  public String row(int i)
    throws Exception
  {
    String pairLine = "";
    if (i >= 0)
      {
        pairLine += textPair.row(i) + textPair.row(i);
        return pairLine;
      }
    else
      throw new Exception("Invalid row " + i);
  } // row(int i)

  /**
   * Determine how many rows are in the block
   */
  @Override
  public int height()
  {
    return textPair.height();
  } //height()

  /**
   * Determine how many columns are in the block
   */
  @Override
  public int width()
  {
    return (2 * textPair.width());
  } //width()

}