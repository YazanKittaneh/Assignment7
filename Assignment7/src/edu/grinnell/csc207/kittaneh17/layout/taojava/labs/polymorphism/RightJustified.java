package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

/**
 * Represents the result of right-justifying the 
 * underlying text block in a block of a width specified
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */

public class RightJustified
    ///DON'T KNOW WHAT YOU MEAN BY WIDTH ON RIGHT
    implements TextBlock
{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock textRight;
  int widthRight = 0;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new right justified block of the specified width
   * 
   * @param tb, a textblock
   * @param width, an int
   */
  public RightJustified(TextBlock tb, int width)
  {
    this.textRight = tb;
    this.widthRight = width;
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
        String rightLine = "";
        int count = 0;

        if (widthRight < textRight.width()) //exception if width given is smaller than textline width
          {
            throw new Exception("Center width smaller than TextLine");
          }

        if (i >= 0)
          {
            while (count < widthRight)
              {
                if (count < textRight.width())
                  {
                    rightLine += textRight.row(i);
                    count = textRight.width();
                  }
                else
                  {
                    rightLine += " ";
                    count++;
                  }
              }
            return rightLine;
          }
        else
          throw new Exception("Invalid row " + i);
  } //String row(int i)

  @Override
  public int height()
  {
    return textRight.height();
  } //height()

  @Override
  public int width()
  {
    return widthRight;
  } //width()

}
