package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

public class TruncatedBlock
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock textTurn;
  int widthTrun = 0;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new truncated block of the specified width.
   * 
   * @param tb , a textblock
   * @param width, an int
   */
  public TruncatedBlock(TextBlock tb, int width)
  {
    this.textTurn = tb;
    this.widthTrun = width;
  } // TruncatedBlock(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the ith row of the block.
   * returns the row up to the width given
   */
  @Override
  public String row(int i)
    throws Exception
  {
    try
      {
        String turnLine = "";

        if (i >= 0)
          {
            turnLine = textTurn.row(i).substring(0, widthTrun);
            return turnLine;
          } // i is a positive number
        else
          throw new Exception("Invalid row " + i);
      }
    catch (Exception e)
      {
        return e.toString();
      }
  } // row(int)

  /**
   * Determine how many columns are in the block.
   */
  @Override
  public int width()
  {
    return textTurn.width();
  } // width()

  /**
   * Determine how many rows are in the block.
   */
  @Override
  public int height()
  {
    return textTurn.height();
  }

} // class TruncatedBlock
