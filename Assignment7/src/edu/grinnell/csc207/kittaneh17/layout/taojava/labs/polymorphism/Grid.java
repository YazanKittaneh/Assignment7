package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

/**
 * Results in a text block of given width 
 * and height, of a single character given
 * 
 * @author Yazan Kittaneh
 * @version 1.1 of October 2014
 */

public class Grid
    implements TextBlock
{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the Grid.
   */
  int widthGrid;
  int heightGrid;
  char chGrid;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new grid with the specified contents.
   */
  public Grid(int width, int height, char ch)
  {
    this.widthGrid = width;
    this.heightGrid = height;
    this.chGrid = ch;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * returns the height of the grid
   */
  @Override
  public int height()
  {
    return heightGrid;
  } //height()

  /**
   * returns the width of the grid
   * 
   */
  @Override
  public int width()
  {
    return widthGrid;
  } //width()


  /**
   * returns a string line of chGrid of length width
   * 
   * @param i, an int
   */
  @Override
  public String row(int i)
    throws Exception
  {

    String gridLine = "";
    int widthCounter = this.width();

    if (i >= 0)
      {
        while (widthCounter > 0)
          {
            gridLine += this.chGrid;
            widthCounter--;
          } //creates line of chGrid of length width
        return gridLine;
      } // i is a positive number
    else
      throw new Exception("Invalid row " + i);

  } //row(int i)

}
