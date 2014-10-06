package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

public class CenteredBlock
    implements TextBlock
{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock textCent;
  int widthCent = 0;

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
    try
      {
        String centLine = "";
        int blankWidth = (widthCent - textCent.width()) / 2;
        int count = 0;
        //System.out.println(blankWidth);
        if (widthCent < textCent.width()) //exception if width given is smaller than textline width
          {
            throw new Exception("Center width smaller than TextLine");
          }
        if (i >= 0)
          {
            while (count < widthCent)
              {
                if (count < blankWidth
                    || count >= (blankWidth + textCent.width()))
                  {
                    centLine += " ";
                    //System.out.println("Within the if: " + centLine);
                    count++;
                  }
                else
                  {
                    centLine += textCent.row(i);
                    count = blankWidth + textCent.width();
                    //System.out.println("Within the else: " + centLine);
                  }
              }
            //System.out.println("Before Result: " + centLine);
            return centLine;
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
