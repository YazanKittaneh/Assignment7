package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

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
   * Create a new pai block
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
   * Get the ith row of the block.
   */
  @Override
  public String row(int i)
    throws Exception
  {
    try
      {
        String pairLine = "";
        int count = 0;
        if (i >= 0)
          {
            pairLine += textPair.row(i) + textPair.row(i);
            return pairLine;
          }
        else
          throw new Exception("Invalid row " + i);
      }
    catch (Exception e)
      {
        return e.toString();
      }
  }

  /**
   * Determine how many rows are in the block.
   */
  @Override
  public int height()
  {
    return textPair.height();
  } //height()

  /**
   * Determine how many columns are in the block.
   */
  @Override
  public int width()
  {
    return (2 * textPair.width());
  } //width()

}