package com.farevee.groceries;

public class NonFood
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  
  String nonName;
  Weight nonWeight;
  int nonPrice;
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public NonFood(String name, Weight weight, int price)
  {
    nonName=name;
    nonWeight=weight;
    nonPrice=price;
  }
  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+ 
  
  
  /**
   * Gives the weight of the nonFood object
   */
  @Override
  public Weight getWeight()
  {
    return nonWeight;
  }

  
  /**
   * Gives the price of the nonFood object
   */
  @Override
  public int getPrice()
  {
    return nonPrice;
  }

  
  /**
   * Gives the name of the nonFood object
   */
  @Override
  public String toString(int i)
    throws Exception
  {
    if(i>=0)
      {
        return nonName;
      }
    else
      throw new Exception("Invalid row " + i);
  } //String toString(int i)

}