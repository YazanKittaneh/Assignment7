package com.farevee.groceries;

public interface Item
{
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  
  
  /**
   * @return
   *    Weight of the item
   */
  public Weight getWeight();
  
  
  
  /**
   * @return
   *    Price of the item
   */
  public int getPrice();
  
  
  
  /**
   * turns the item into a string
   * 
   * @pre i > 0
   * @exception Exception
   *              if the row number is invalid.
   */
  public String toString(int i)
      throws Exception;
} // interface Item
