package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

/**
 * Represents the result of centering a text block within a certain width
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */

public class CenteredBlock
    implements TextBlock
{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock textCent; //creates object TextBlock textCent
  int widthCent = 0; //creates int widthCent

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new centered block of the specified width
   * 
   * @param tb , a textblock
   * @param width, an int
   */
  public CenteredBlock(TextBlock tb, int width)
  {
    this.textCent = tb;
    this.widthCent = width;
  } // TruncatedBlock(TextBlock, int)

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
    String centLine = "";
    int blankWidth = (widthCent - textCent.width()) / 2;
    int count = 0;

    if (widthCent < textCent.width()) //exception if width given is smaller than textline width
      {
        throw new Exception("Center width smaller than TextLine");
      } //if
    if (i >= 0)
      {
        while (count < widthCent)
          {
            if (count < blankWidth || count >= (blankWidth + textCent.width()))
              {
                centLine += " ";
                count++;
              } //if black count is within blackWidth and the blackWidth+textCent.width()
            else
              {
                centLine += textCent.row(i);
                count = blankWidth + textCent.width();
              } //else concatenate texctCent contents onto centLine
                //move count to blackWidth+textCent.width()
          } //while
        return centLine;
      } // if i is greater to or equal to 0
    else
      throw new Exception("Invalid row " + i);
  } //row(int i)

  /**
   * Determine how many rows are in the block.
   */
  @Override
  public int height()
  {
    return textCent.height();
  } //height()

  /**
   * Determine how many columns are in the block.
   */
  @Override
  public int width()
  {
    return widthCent; //Charlie Gao helped me debug the issue here
  } //width()

}
