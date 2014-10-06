package edu.grinnell.csc207.kittaneh17.layout.taojava.labs.polymorphism;

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
   * Preconditions:
   *            [None]
   * Postconditions:
   *            returns the height of the grid
   */
  @Override
  public int height()
  {
    return heightGrid;
  } //height()

  /**
   * Preconditions:
   *            [None]
   * Postconditions:
   *            returns the width of the grid
   */
  @Override
  public int width()
  {
    return widthGrid;
  } //width()

  /**
   * 
   * Preconditions:
   *            i is greater than 0
   * Postconditions:
   *            returns a string line of chGrid of length width
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
          }
        return gridLine;
      } // i is a positive number
    else
      throw new Exception("Invalid row " + i);

  } //row(int i)

}
